package com.ericsson.designpattern.behavioral.strategy;

public class MuteQuack implements QuackBehavior {

	public void quack() {
		System.out.println("<<silent>>");
	}

}
