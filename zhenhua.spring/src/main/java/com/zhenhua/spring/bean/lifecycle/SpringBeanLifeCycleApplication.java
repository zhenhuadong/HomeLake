package com.zhenhua.spring.bean.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//https://www.concretepage.com/spring/spring-bean-life-cycle-tutorial

@SpringBootApplication
public class SpringBeanLifeCycleApplication {

	public static void main(String[] args) {
		System.out.println("demo DemoSpringLifeCycleBean start .... ");
		ConfigurableApplicationContext context = SpringApplication.run(SpringBeanLifeCycleApplication.class, args);
		DemoSpringLifeCycleBean demo = (DemoSpringLifeCycleBean) context.getBean("demoSpringLifeCycleBean");
		System.out.println(demo.getName());
		context.close();
		System.out.println("demo DemoSpringLifeCycleBean end .... ");
		
//		System.out.println("demo DemoSpringLifeCycleBean start .... ");
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring_bean.xml");
//		DemoSpringLifeCycleBean demo = (DemoSpringLifeCycleBean) context.getBean("demoSpringLifeCycleBean");
//		System.out.println(demo.getName());
//		((AbstractApplicationContext) context).close();
//		System.out.println("demo DemoSpringLifeCycleBean end .... ");

	}

}
