package com.ericsson.designpattern.behavioral.strategy;

public class ModelDuck extends Duck {
	public ModelDuck(){
		flyBehavior = new FlyNoWay();
		quckBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("I'm a model duck");
	}

}
