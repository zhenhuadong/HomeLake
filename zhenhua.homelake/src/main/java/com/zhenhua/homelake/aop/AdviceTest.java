package com.zhenhua.homelake.aop;

import com.zhenhua.homelake.aop.advice.CustomerService;

public class AdviceTest {

	public static void main(String[] args) {
		CustomerService cs = new CustomerService("advice", "com.zhenhua.homelake.aop");
		cs.execute();
	}

}
