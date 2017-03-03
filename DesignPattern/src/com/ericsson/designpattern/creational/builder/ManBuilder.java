package com.ericsson.designpattern.creational.builder;

public class ManBuilder implements PersonBuilder {
	Person person;
	
	public ManBuilder(){
		person = new Man();
	}

	@Override
	public void buildHead() {
		person.setHead("ÄÐÍ·");
	}

	@Override
	public void buildBody() {
		person.setBody("ÄÐÉí");
	}

	@Override
	public void buildFoot() {
		person.setFoot("ÄÐ×ã");

	}

	@Override
	public Person buildPerson() {
		return person;
	}

}
