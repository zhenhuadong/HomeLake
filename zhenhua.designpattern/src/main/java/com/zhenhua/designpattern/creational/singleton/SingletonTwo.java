package com.zhenhua.designpattern.creational.singleton;

public class SingletonTwo {
	private static  SingletonTwo singletonTwo = null;
	private SingletonTwo(){
		System.out.println("SingletonTwo simple -- Lazy init, not safe for multi-Thread");
	}
	
	public static SingletonTwo getInstance(){
		if(singletonTwo == null){
			singletonTwo = new SingletonTwo();
		}
		
		return singletonTwo;
	}
	


}
