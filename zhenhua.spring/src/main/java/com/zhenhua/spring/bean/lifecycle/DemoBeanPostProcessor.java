package com.zhenhua.spring.bean.lifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class DemoBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		if (bean instanceof DemoSpringLifeCycleBean) {
			((DemoSpringLifeCycleBean) bean).postProcessBeforeInitialization();
		}
		return bean;

	}

	public Object postProcessAfterInitialization(Object bean, String beanName) {
		if (bean instanceof DemoSpringLifeCycleBean) {
			((DemoSpringLifeCycleBean) bean).postProcessAfterInitialization();
		}
		return bean;
	}

}
