package com.zhenhua.designpattern.creational.singleton;

public class SingletonFive {
	private static class SingletonInternal{
		private static final SingletonFive singletonFive = new SingletonFive();
	}
	
	private SingletonFive(){
		System.out.println("SingletonFive complex -- Lazy init, safe for multi-Thread");
	}
	
	public static SingletonFive getInstance(){
		return SingletonInternal.singletonFive;
	}

}
