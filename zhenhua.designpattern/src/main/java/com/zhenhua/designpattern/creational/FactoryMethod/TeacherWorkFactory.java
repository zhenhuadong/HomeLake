package com.zhenhua.designpattern.creational.FactoryMethod;

public class TeacherWorkFactory implements IWorkFactory {

	public IWork getWork() {
		return new TeacherWork();
	}

}
