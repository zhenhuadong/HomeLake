# ibdata1 increase too big more than 300G

## 问题
在线运行一段时间（几个月）后，发现ibdata1文件变的非常大（几百个G），并且随着时间增加而变大，很快将耗尽所在的磁盘。
```
SC-2:/var/mysql/data # ls -lart -h
total 882G
....
-rw-r----- 1 mysql mysql 1.9G May  2 09:13 ibtmp1
-rw-r----- 1 mysql mysql 2.0G May  2 10:42 ib_logfile1
-rw-r----- 1 mysql mysql 2.0G May  2 15:00 ib_logfile0
**-rw-r----- 1 mysql mysql 876G May  2 15:00 ibdata1**
```
## 分析
ibdata1文件中包含什么？ 为什么会随时间增大？

### ibdata1包含什么：
参考官网https://dev.mysql.com/doc/refman/5.7/en/innodb-system-tablespace.html
简单的说ibdata1文件包含如下：
- data dictionary aka metadata of InnoDB tables
- change buffer
- doublewrite buffer
- undo logs
- table and index data if tables are created in the system tablespace (not file-per-table or general tablespaces)

### 为什么ibdata1会变这么大？
可以用./innochecksum /path/to/ibdata1 分析具体情况
常见的原因是某个join很多表的查询进程因为某种原因一直执行很久，结果导致后续在这些表上的操作，都要记录UNDO log到ibdata1中，从而使这个表变的巨大无比。

- 可以使用"show engine innodb status \G" 查看是否用运行很长时间的transaction. 
```
SHOW ENGINE INNODB STATUS
---TRANSACTION 36E, ACTIVE 1256288 sec  <-- 这个就运行了很长时间
```
- 可以使用"show full processlist \G" 查看是否有执行很长时间的进程
```
SHOW FULL PROCESSLIST\G
*************************** 2. row ***************************
     Id: 235662
   User: drill
   Host: 172.17.242.99:12397
     db: user_data
Command: Execute
   Time: 403503
  State: Sending data
   Info: select count(*) from Ind_Data, CommonData where Ind_Data.ENTRY_KEY=CommonData.ENTRY_KEY
```
或者show processlist
```
|9866|drill|169.254.121.2:45091|NULL|Execute|2274092|Creating sort index| SELECT * FROM (SELECT * FROM `user_data`.`identities` WHERE `IM` LIKE '20605%') AS `t` L |
```
### 怎么解决持续增加的问题
kill 这个长时间运行的查询，释放老的UNDO日志占用的空间。这一空间可以被重用，但是日志文件本身不变小。

### ibdata1能变小吗
因为包含data dictionary of innodb, 所以不能直接删除或者清空。一般只能备份/删除/恢复的办法解决。
参考 https://www.percona.com/blog/2013/08/20/why-is-the-ibdata1-file-continuously-growing-in-mysql/

## UNDO日志
- 什么是UNDO日志，它有什么用？
UNDO日志记录当前事务相反的操作（执行insert, 就在UNDO中记录delete), 事务失败时候可以恢复数据到之前的状态。主要用来保证保证事务的原子性。
UNDO日志在MySQL中的两个作用：回滚和MVCC。MVCC是通过事务版本号来区分事务开始时候的数据。 添加/更新/删除时候都会增加版本号。查询的时候，大于查询事务的版本号的添加/删除/更新操作都必须保留UNDO日志。这样才能保证查询到的数据是事务发起时候的数据。

- 能不能把UNDO日志分离出来?
可以在my.cnf中配置undo日志，
```
#undo log
innodb_undo_directory = /var/data_analytic/data
innodb_undo_tablespaces = 2   <-- 两个UNDO日志文件
innodb_undo_logs = 128        <-- 128个回滚段
innodb_undo_log_truncate = ON <-- 打开truncate日志文件开关
innodb_max_undo_log_size = 500M   <-- UNDO日志文件的大小
innodb_purge_rseg_truncate_frequency = 128
```
- 对应的REDO日志， 保证事务的持久性
```
innodb_flush_log_at_trx_commit={0|1|2} # 指定何时将事务日志刷到磁盘，默认为1。
0表示每秒将"log buffer"同步到"os buffer"且从"os buffer"刷到磁盘日志文件中。
1表示每事务提交都将"log buffer"同步到"os buffer"且从"os buffer"刷到磁盘日志文件中。
2表示每事务提交都将"log buffer"同步到"os buffer"但每秒才从"os buffer"刷到磁盘日志文件中。
innodb_log_buffer_size：# log buffer的大小，默认8M
innodb_log_file_size：#事务日志的大小，默认5M
innodb_log_files_group =2：# 事务日志组中的事务日志文件个数，默认2个
innodb_log_group_home_dir =./：# 事务日志组路径，当前目录表示数据目录
```
