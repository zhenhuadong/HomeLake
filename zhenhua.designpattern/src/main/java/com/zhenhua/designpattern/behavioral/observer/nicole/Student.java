package com.zhenhua.designpattern.behavioral.observer.nicole;

import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {

	public Student (Observable o){
		o.addObserver(this);
	}
	
	public void update(Observable o, Object arg) {

		if(o instanceof Weather){
			Weather weather = (Weather) o;
			showYourVoice((String)arg);
		}
	}
	
	public void showYourVoice(String status){
		System.out.println("I am a student and the weather is " + status);
	}

}
