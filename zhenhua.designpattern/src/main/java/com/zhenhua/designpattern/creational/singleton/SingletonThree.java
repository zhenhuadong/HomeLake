package com.zhenhua.designpattern.creational.singleton;

public class SingletonThree {
	private static SingletonThree singletonThree = null;
	private SingletonThree(){
		System.out.println("SingletonThree complex -- Lazy init, safe for multi-Thread");
	}
	
	public synchronized static SingletonThree getInstance(){
		if(singletonThree == null){
			singletonThree = new SingletonThree();
		}
		
		return singletonThree;
	}
}
