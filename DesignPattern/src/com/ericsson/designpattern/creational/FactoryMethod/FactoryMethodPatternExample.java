package com.ericsson.designpattern.creational.FactoryMethod;

public class FactoryMethodPatternExample {

	/**
	 * 
	 * Creator: IWorkFactory  
	 *    Creator has one Factory method getWork() to create one new Product instance
	 * Product: IWork
	 *    The product instance has one interface method
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        IWorkFactory studentWorkFactory = new StudentWorkFactory();
        studentWorkFactory.getWork().doWork();
        
        IWorkFactory teacherWorkFactory = new TeacherWorkFactory();
        teacherWorkFactory.getWork().doWork();

	}

}
