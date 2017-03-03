package com.ericsson.designpattern.creational.builder;

public class Main {

	public static void main(String[] args) {
		PersonDirectory pd = new PersonDirectory();
		Person person = pd.constructPerson(new ManBuilder());
		
		System.out.println(person.getHead());
		System.out.println(person.getBody());
		System.out.println(person.getFoot());

	}

}
