package com.zhenhua.spring.bean.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoSpringConfiguration {
	  @Bean
	  public DemoBeanPostProcessor myBeanPostProcessor(){
	    return new DemoBeanPostProcessor();
	  }
	  @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
	  public DemoSpringLifeCycleBean demoSpringLifeCycleBean2(){
	    return new DemoSpringLifeCycleBean();
	  }
}