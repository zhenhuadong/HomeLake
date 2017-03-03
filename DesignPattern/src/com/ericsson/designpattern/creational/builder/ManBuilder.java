package com.ericsson.designpattern.creational.builder;

public class ManBuilder implements PersonBuilder {
	Person person;
	
	public ManBuilder(){
		person = new Man();
	}

	@Override
	public void buildHead() {
		person.setHead("��ͷ");
	}

	@Override
	public void buildBody() {
		person.setBody("����");
	}

	@Override
	public void buildFoot() {
		person.setFoot("����");

	}

	@Override
	public Person buildPerson() {
		return person;
	}

}
