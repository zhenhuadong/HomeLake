package com.zhenhua.spring.bean.lifecycle.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource("classpath:application.properties")
public class DemoSpringConfiguration {
	@Bean
	public DemoBeanPostProcessor demoBeanPostProcessor() {
		return new DemoBeanPostProcessor();
	}
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
	public DemoSpringLifeCycleBean demoSpringLifeCycleBean() {
		return new DemoSpringLifeCycleBean();
	}
}