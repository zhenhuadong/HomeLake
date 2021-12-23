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

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * @author Zhenhua Dong
 *
 */
public class MyAspect {

	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around enter ..." + pjp.getSignature().toShortString());
		long start = System.nanoTime();
		Object obj = pjp.proceed(pjp.getArgs());
		System.out.println(pjp.getSignature().toShortString() + " spent : " + (System.nanoTime() - start));
		System.out.println("around exit ..." + pjp.getSignature().toShortString());
		return obj;
	}


	public void before(JoinPoint joinPoint) {
		System.out.println("enter ..." + joinPoint.getSignature().toShortString());
		for (Object signatureArg : joinPoint.getArgs()) {
			System.out.println("Arg: " + signatureArg);
		}
	}

	public void after(JoinPoint joinPoint) {
		System.out.println("exit ..." + joinPoint.getSignature().toShortString());
	}
}
