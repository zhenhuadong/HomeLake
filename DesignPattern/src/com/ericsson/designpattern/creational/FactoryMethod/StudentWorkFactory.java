package com.ericsson.designpattern.creational.FactoryMethod;

public class StudentWorkFactory implements IWorkFactory {

	public IWork getWork() {
		return new StudentWork();
	}

}
