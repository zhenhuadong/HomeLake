

iptables

四表五链
- 四表：
  - filter
    筛选谁能进来出去
    链：INPUT, FORWARD, OUTPUT
  - nat
    IP转发或端口转发
    链：PREROUTING, POSTROUTING
  - mangle
    链：五个都有
  - raw
    链：

- 五链:
  -  

策略的增删改查

查：
iptables -L
iptables -L -t filter
iptables -L -v -n

删：
iptables -D INPUT 1

增：
iptables -A INPUT -p tcp -dport 80 -j ACCEPT
iptables -I INPUT 1 -p tcp -dport 80 -j ACCEPT

改：
iptables -R INPUT 1 -p tcp -dport 88 -j ACCEPT


过滤策略是从上到下顺序匹配

