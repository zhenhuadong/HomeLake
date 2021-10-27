
# 19.1 说一下 jvm 的主要组成部分？及其作用？
JVM主要包含四部分：
- 类加载器(ClassLoader)
- 运行时数据区(Runtime Data Area)
- 执行引擎(Execution Engine)
- 本地库接口(Native Method Interface JNI)

JVM主要组成部分参考下图
![JVM 组成部分](../pictures/java_jvm_architecture.png)

## 19.1.1 类加载器是什么？有哪些？
类加载器（ClassLoader)是java运行环境（JRE）的一部分，它动态的把java源文件编译后的字节码文件加载到JVM中。

类加载器分为:
- 启动类加载器(bootstrap):  加载JDK中的核心类库
- 扩展类加载器(extension): ，加载（java.ext.dir）JAVA_HOME/jre/lib/ext目录下的jar包 
- 系统类加载器(application): ，加载java命令中的classpath或者其它系统属性所指定的jar类包和类路径
- 自定义加载器(customer)：自定义加载器
- 线程上下文加载器
  

一个重要组件，它把Java源文件编译后的字节码文件加载到内存生成一个对应的类

## 19.1.2 类加载器是怎么加载类的？

## 19.1.3 类加载器双亲委派模型和线程上下文加载器

## 19.1.4 类加载器在框架中如何使用的？

java代码*.java,先通过javac编译出*.class文件，然后JVM的class loader负责把其加载到虚拟机。
  - 加载过程分为：
    - 1.1 loading: 加载到内存中
    - 1.2 linking-verification: 校验是否符合class文件标准
    - 1.3 linking-preparation: 类文件静态变量赋默认值 （注意不是初始值）
    - 1.4 linking-resolution: 把class文件常量池中用到的符号引用转换成直接内存地址
    - 1.5 initialzing： 静态变量赋初始值，静态块执行
  - 类加载器分层：
    - bootstrap: 启动类加载器 加载JDK中的核心类库
    - extension: 扩展类加载器，加载（java.ext.dir）JAVA_HOME/jre/lib/ext目录下的jar包 
    - application: 系统类加载器，加载java命令中的classpath或者其它系统属性所指定的jar类包和类路径
    - customer：自定义加载器
  - 采用双亲委派加载模式：就是先判断是否加载：判断从自定以加载器开始逐级到bootstrap。如果没有加载，则开始加载：加载顺序是从bootstrap开始逐级到customer 
  - 类加载带来的动态特性: tomcat/glassfish等使用classload实现了应用隔离，通过OSGI实现模块可插拔。
- 执行引擎 (Execution Engine)
  - 解释器
  - JIT编译器
  - 垃圾收集器：搜集并删除未引用的对象
- 本地库接口(Native Interface)
- 运行时数据区(Runtime Data Area)
  - 方法区：JDK7之前成为永久代，使用JVM内存MaxPermsize; JDK8开始使用元空间,直接使用本地内存,可以限制也可以不限制大小（限制使用：MetaspaceSize)。 当然超出内存会出现OOM:"PermGen space" 或者 OOM:"Metaspace"。 往往是加载了大量的第三方包，部署的应用过多，大量动态生成的反射类等等原因导致的。
  - 堆区![JVM heap](./pictures/jvm_heap.png)
    - 新生代：eden+from+to, 垃圾回收minorGC采用复制算法。eden内存不足时触发一次minorGC. 多次(默认15次）minorGC后仍然存活的就进入老年代。
    - 老年代: 垃圾回收majorGC采用标记-清除/整理算法. 老年代不足分配大对象，或者接受从新生代晋升的对象时就会触发一次。
    - FullGC: 垃圾回收整个堆包括新生代+老年代+永久代（如果有）
    - 垃圾回收算法有哪些：


