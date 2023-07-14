
# Java内置annotation
- Java annotation是什么？
- Java 内置注解有多少？
- Java annotation 作用在什么上？有@Target指定，也就是ElementType枚举的ANNOTATION_TYPE , CONSTRUCTOR , FIELD , LOCAL_VARIABLE , METHOD , PACKAGE , PARAMETER , TYPE , and TYPE_PARAMETER
- Java annotation 什么时候起作用？ 有@Retention指定，也就是RetentionPolicy枚举到SOURCE, CLASS, RUNTIME
- Java annotation 怎么起作用的？
## Java内置9个注解：其中7个是一直都有都
### 四个元注解
作用在其他注解的注解(或者说 元注解)是:
- @Retention - 标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问。
- @Documented - 标记这些注解是否包含在用户文档中。
- @Target - 标记这个注解应该是哪种 Java 成员。
- @Inherited - 标记这个注解是继承于哪个注解类(默认 注解并没有继承于任何子类)

### 五个代码注解 用于编码检查
作用在代码的注解是
- @Override - 检查该方法是否是重写方法。如果发现其父类，或者是引用的接口中并没有该方法时，会报编译错误。 在source阶段起作用，作用在方法上
- @Deprecated - 标记过时方法。如果使用该方法，会报编译警告。 在运Runtime生效，@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
- @SuppressWarnings - 指示编译器去忽略注解中声明的警告。 在source阶段起作用，作用在几乎所有到类型上
- @FunctionalInterface  1.8 引入 在RUNTIME生效，作用在接口上（type) 
- @SafeVarargs 1.7 引入 在RUNTIME生效，作用在CONSTRUCTOR，METHOD上 必须是static或final方法。代码不会对参数做安全检查。类似@SuppressWarnings("unchecked")

# Junit 注解

# Spring 注解
- @Component
  - @Controller
  - @Service
  - @Repository
- @Autowired  --- DI 依赖注入， 核心注解
- @Transactional

- @Cacheable
- 
refer to: https://www.cnblogs.com/shy1766IT/p/9993611.html
