package com.zhenhua.designpattern.creational.builder;

public class PersonDirectory {
	public Person constructPerson(PersonBuilder pb){
		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();
		return pb.buildPerson();
	}

}
