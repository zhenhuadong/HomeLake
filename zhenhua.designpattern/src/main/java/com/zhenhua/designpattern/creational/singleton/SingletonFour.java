package com.zhenhua.designpattern.creational.singleton;

public class SingletonFour {
	private volatile static SingletonFour singletonFour = null;
	private SingletonFour(){
		System.out.println("SingletonFour complex -- Lazy init, safe for multi-Thread");
	}
	
	public static SingletonFour getInstance(){
		if(singletonFour == null){
			synchronized (SingletonFour.class){
				if(singletonFour == null){
					singletonFour = new SingletonFour();
				}
			}
		}
		
		return singletonFour;
	}
}
