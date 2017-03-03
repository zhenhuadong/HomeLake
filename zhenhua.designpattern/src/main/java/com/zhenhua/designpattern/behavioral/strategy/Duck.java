package com.zhenhua.designpattern.behavioral.strategy;

public abstract class Duck {
	FlyBehavior flyBehavior;
	protected QuackBehavior quckBehavior;

	
	public abstract void display();
	
	public void performQuck(){
		quckBehavior.quack();
	}
	
	public void performFly(){
		flyBehavior.fly();
	}
	
	public void swim(){
		System.out.println("All ducks float, even decoys!");
	}
	
	public FlyBehavior getFlyBehavior() {
		return flyBehavior;
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	
	public QuackBehavior getQuckBehavior() {
		return quckBehavior;
	}

	public void setQuckBehavior(QuackBehavior quckBehavior) {
		this.quckBehavior = quckBehavior;
	}
}
