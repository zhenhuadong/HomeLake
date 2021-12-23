/*
 * Copyright (C) 2021- 2021 Zhenhua Dong
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.zhenhua.spring.aop.aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zhenhua Dong
 *
 */
public class DemoAspect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("demo AspectJ start .... ");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_aop.xml");
		Business business = context.getBean(Business.class, "business");
		business.meeting();
		String uuid = business.getMeetingId();
		business.joinMeeting(uuid);
		business.meeting(uuid);
		((AbstractApplicationContext) context).close();
		System.out.println("demo AspectJ end .... ");
	}

}
