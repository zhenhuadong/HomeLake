package com.zhenhua.designpattern.creational.builder;

public class ManBuilder implements PersonBuilder {
	Person person;
	
	public ManBuilder(){
		person = new Man();
	}

	@Override
	public void buildHead() {
		person.setHead("ÄĞÍ·");
	}

	@Override
	public void buildBody() {
		person.setBody("ÄĞÉí");
	}

	@Override
	public void buildFoot() {
		person.setFoot("ÄĞ×ã");

	}

	@Override
	public Person buildPerson() {
		return person;
	}

}
