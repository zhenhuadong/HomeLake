package com.zhenhua.designpattern.creational.singleton;

public class SingletonOne {
	private static SingletonOne singletoneOne = new SingletonOne();
	private SingletonOne(){
		System.out.println("SingletonOne simple -- safe for multi-Thread");
	}
	
	public static SingletonOne getInstance(){
		return singletoneOne;
	}

}
