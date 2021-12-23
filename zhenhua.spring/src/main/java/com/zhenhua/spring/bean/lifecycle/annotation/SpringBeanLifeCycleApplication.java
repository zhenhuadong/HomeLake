package com.zhenhua.spring.bean.lifecycle.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//https://www.concretepage.com/spring/spring-bean-life-cycle-tutorial

/**
 * don't need to provide the spring_bean.xml
 * 
demo DemoSpringLifeCycleBean start .... 

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.6)

2021-12-22 15:26:23.738  INFO 26012 --- [           main] z.s.b.l.a.SpringBeanLifeCycleApplication : Starting SpringBeanLifeCycleApplication using Java 1.8.0_251 on CN-00004012 with PID 26012 (C:\work\code\github\HomeLake\zhenhua.spring\target\classes started by ezhendo in C:\work\code\github\HomeLake\zhenhua.spring)
2021-12-22 15:26:23.741  INFO 26012 --- [           main] z.s.b.l.a.SpringBeanLifeCycleApplication : No active profile set, falling back to default profiles: default
2021-12-22 15:26:24.156  INFO 26012 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'demoSpringConfiguration' of type [com.zhenhua.spring.bean.lifecycle.annotation.DemoSpringConfiguration$$EnhancerBySpringCGLIB$$d3b6baa3] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
1st: Constructor...null
3rd: setBeanName from BeanNameAware called with name: demoSpringLifeCycleBean
4th: setBeanClassLoader for BeanClassLoaderAware calleddemo1
5th: setBeanFactory from BeanFactoryAware called with org.springframework.beans.factory.support.DefaultListableBeanFactory@4b0d79fc: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory,springBeanLifeCycleApplication,org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory,demoSpringConfiguration,demoBeanPostProcessor,demoSpringLifeCycleBean,org.springframework.boot.autoconfigure.AutoConfigurationPackages,org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration,propertySourcesPlaceholderConfigurer,org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration,forceAutoProxyCreatorToUseClassProxying,org.springframework.boot.autoconfigure.aop.AopAutoConfiguration,org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration,applicationAvailability,org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration,org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor,org.springframework.boot.context.internalConfigurationPropertiesBinderFactory,org.springframework.boot.context.internalConfigurationPropertiesBinder,org.springframework.boot.context.properties.BoundConfigurationProperties,org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.methodValidationExcludeFilter,org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration,lifecycleProcessor,spring.lifecycle-org.springframework.boot.autoconfigure.context.LifecycleProperties,org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration,spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties,org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration,spring.sql.init-org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties,org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer$DependsOnDatabaseInitializationPostProcessor,org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration,taskExecutorBuilder,applicationTaskExecutor,spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties,org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration,scheduledBeanLazyInitializationExcludeFilter,taskSchedulerBuilder,spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties,org.springframework.aop.config.internalAutoProxyCreator]; root of factory hierarchycom.zhenhua.spring.bean.lifecycle.annotation.DemoSpringLifeCycleBean
6th: setApplicationContext for ApplicationContextAware called with 41
7th: BeforeInitialization for BeanPostProcessor called
8th: postConstruct annotated method called
9th: afterPropertiesSet from InitializingBean called.
10th: initMethod for BeanPostProcessor called
11th: AfterInitialization for BeanPostProcessor called
2021-12-22 15:26:24.250  INFO 26012 --- [           main] z.s.b.l.a.SpringBeanLifeCycleApplication : Started SpringBeanLifeCycleApplication in 0.99 seconds (JVM running for 1.57)
demo1
12th: preDestroy annotated method called
13th: destroy from DisposableBean called.
14th: destroyMethod for BeanPostProcessor called
demo DemoSpringLifeCycleBean end .... 

 * @author Zhenhua Dong
 *
 */

@SpringBootApplication
public class SpringBeanLifeCycleApplication {

	public static void main(String[] args) {
		System.out.println("demo DemoSpringLifeCycleBean start .... ");
		ConfigurableApplicationContext context = SpringApplication.run(SpringBeanLifeCycleApplication.class, args);
		// get primary bean 
//		DemoSpringLifeCycleBean demo = context.getBean(DemoSpringLifeCycleBean.class);
		// get demoSpringLifeCycleBean bean
//		DemoSpringLifeCycleBean demo = context.getBean(DemoSpringLifeCycleBean.class, "demoSpringLifeCycleBean");
		
		DemoSpringLifeCycleBean demo = (DemoSpringLifeCycleBean) context.getBean("demoSpringLifeCycleBean");

//		Properties props = System.getProperties();
//		String name=props.getProperty("${spring.lifecycle.bean.name}");
//		System.out.println(name);
		
		System.out.println(demo.getName());
		context.close();
		System.out.println("demo DemoSpringLifeCycleBean end .... ");
		
		
	}

}
