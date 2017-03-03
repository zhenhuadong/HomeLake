package com.ericsson.designpattern.behavioral.strategy;

public class DecoyDuck extends Duck {

	public DecoyDuck(){
		setFlyBehavior(new FlyNoWay());
		setQuckBehavior(new MuteQuack());
	}
	
	@Override
	public void display() {
		System.out.println("I'm a duck Decoy");
	}

}
