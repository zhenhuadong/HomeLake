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

import java.util.UUID;

/**
 * @author Zhenhua Dong
 *
 */
public class Business {
	public void meeting(){
		System.out.println("i am in a meeting");
	}
	
	public String getMeetingId(){
		UUID uuid = UUID.randomUUID();
		System.out.println("i get a meeting id = " + uuid.toString());
		return uuid.toString();
	}
	
	public boolean joinMeeting(String uuid){
		System.out.println("i am join a meeting with id = " + uuid.toString());
		return true;
	}
	
	public void meeting(String id){
		System.out.println("i am in a meeting with id = " + id);
	}
}
