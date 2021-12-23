package com.zhenhua.spring.bean.lifecycle.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//https://www.concretepage.com/spring/spring-bean-life-cycle-tutorial

/**
 * mvn clean package
 * java -cp zhenhua.spring-0.0.1-SNAPSHOT.jar 
demo DemoSpringLifeCycleBean start .... 
15:25:55.087 [main] DEBUG org.springframework.context.support.ClassPathXmlApplicationContext - Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@123a439b
15:25:55.446 [main] DEBUG org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loaded 2 bean definitions from class path resource [spring_bean.xml]
15:25:55.503 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'com.zhenhua.spring.bean.lifecycle.xml.DemoBeanPostProcessor#0'
15:25:55.533 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'demoSpringLifeCycleBean'
1st: Constructor...null
2nd: setName...demo2
3rd: setBeanName from BeanNameAware called with name: demoSpringLifeCycleBean
4th: setBeanClassLoader for BeanClassLoaderAware calleddemo2
5th: setBeanFactory from BeanFactoryAware called with org.springframework.beans.factory.support.DefaultListableBeanFactory@3f49dace: defining beans [demoSpringLifeCycleBean,com.zhenhua.spring.bean.lifecycle.xml.DemoBeanPostProcessor#0]; root of factory hierarchycom.zhenhua.spring.bean.lifecycle.xml.DemoSpringLifeCycleBean
6th: setApplicationContext for ApplicationContextAware called with 2
7th: postProcessBeforeInitialization for BeanPostProcessor called
9th: afterPropertiesSet from InitializingBean called.
10th: initMethod for BeanPostProcessor called
11th: postProcessAfterInitialization for BeanPostProcessor called
demo2
15:25:55.629 [main] DEBUG org.springframework.context.support.ClassPathXmlApplicationContext - Closing org.springframework.context.support.ClassPathXmlApplicationContext@123a439b, started on Wed Dec 22 15:25:55 CST 2021
13th: destroy from DisposableBean called.
14th: destroyMethod for BeanPostProcessor called
demo DemoSpringLifeCycleBean end .... 

 * @author Zhenhua Dong
 *
 */
public class SpringBeanLifeCycleApplication {
	public static void main(String[] args) {		
		System.out.println("demo DemoSpringLifeCycleBean start .... ");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_bean.xml");
		DemoSpringLifeCycleBean demo = (DemoSpringLifeCycleBean) context.getBean("demoSpringLifeCycleBean");
		System.out.println(demo.getName());
		((AbstractApplicationContext) context).close();
		System.out.println("demo DemoSpringLifeCycleBean end .... ");
	}

}
