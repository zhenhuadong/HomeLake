package com.ericsson.designpattern.behavioral.strategy;

/*
 * 
 * This class is try to demo Strategy design pattern.
 * There are lots of class (RedHeadDuck, MallardDuck, RubberDuck) inherit from Duck.
 * Generally, Duck has two common methods fly() and quack(), but they may have 
 * different behaviors (such as algorithms).
 * In future, we may need to add more class like (DecoyDuck), and new class may 
 * have different behaviors (fly/quack in different way). 
 * At the same time, we may need to add more behaviors to exist inherit duck.
 * 
 * In the scenario, we can use strategy design pattern.
 * 1. use Interface FlyBehavior and QuackBehavior, so we can implement different behaviors in future.
 * 2. use set method to inject the different behaviors for any inheritor class and main logic. 
 * 
 * Design principle
 * 1. program to an interface, not an implementation
 * 2. favor composition over inheritance
 * 3. Indentify the aspects of your application that vary and separate them from what stays the same
 * 
 * @author ezhendo
 */
public class MiniDuckSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 1. existing Modelduck
		Duck duck = new ModelDuck();
		duck.performFly();
		duck.performQuck();
		
		// 2. introduce one new fly behavior for existing Modelduck
		duck.setFlyBehavior(new FlyRocketPowered());
		duck.performFly();
		duck.performQuck();
		
		// 3. introduce one new inheritor duck named DecoyDuck
		duck = new DecoyDuck();
		duck.performFly();
		duck.performQuck();
		
	}

}
