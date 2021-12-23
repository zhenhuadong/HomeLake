package com.zhenhua.spring.bean.lifecycle.xml;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 8th, 12th depends on annotation @PostConstruct @PreDestroy
 * 
 * 1st, 2nd don't depend any interface
 * 3rd, 4th, 5th, 6th depend on BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware
 * 7th depends on the handlerBean who implement BeanPostProcessor
 * 9th depends on InitializingBean
 * 10th depends on init-method="initMethod" in spring_bean.xml
 * 11th depends on the handlerBean who implement BeanPostProcessor
 * 13th depends on DisposableBean
 * 14th depends on destroy-method="destroyMethod" in spring_bean.xml
 * 
 * 
 * @author Zhenhua Dong
 *
 */
public class DemoSpringLifeCycleBean
		implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware, InitializingBean,
		DisposableBean{

	private String name;

	// Constructor implementation
	public DemoSpringLifeCycleBean() {
		System.out.println("1st: Constructor..." + this.name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("2nd: setName..."  + this.name);
	}
	
	// Implemented from BeanNameAware
	@Override
	public void setBeanName(String name) {
		System.out.println("3rd: setBeanName from BeanNameAware called with name: " + name);
	}

	// Implemented from BeanClassLoaderAware
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("4th: setBeanClassLoader for BeanClassLoaderAware called"  + this.name);		
	}

	// Implemented from BeanFactoryAware
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("5th: setBeanFactory from BeanFactoryAware called with " 
				+ beanFactory 
				+ beanFactory.getBean("demoSpringLifeCycleBean").getClass().getName());
	}
	
	// Implemented from ApplicaticationContextAware
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("6th: setApplicationContext for ApplicationContextAware called with " + applicationContext.getBeanDefinitionCount());
	}

	// This is handle by a BeanPostProcessor together with other beans before bean initialization
	public void postProcessBeforeInitialization() {
		System.out.println("7th: postProcessBeforeInitialization for BeanPostProcessor called");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("8th: postConstruct annotated method called");
	}
	
	// Implemented from InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("9th: afterPropertiesSet from InitializingBean called.");
	}
	
	public void initMethod() {
		System.out.println("10th: initMethod for BeanPostProcessor called");
	}

	// This is handle by a BeanPostProcessor together with other beans after bean initialization
	public void postProcessAfterInitialization() {
		System.out.println("11th: postProcessAfterInitialization for BeanPostProcessor called");
	}
	
	protected void finalize() {
		System.out.println("---inside finalize---");
	}
	

	@PreDestroy
	public void preDestroy() {
		System.out.println("12th: preDestroy annotated method called");
	}

	// Implemented from DisposeableBean
	@Override
	public void destroy() throws Exception {
		System.out.println("13th: destroy from DisposableBean called.");
	}	
	
	public void destroyMethod() {
		System.out.println("14th: destroyMethod for BeanPostProcessor called");
	}



}
