package com.zhenhua.designpattern.behavioral.observer.nicole;

import java.util.Observable;
import java.util.Observer;


public class Tourist implements Observer{

	public Tourist (Observable o){
		o.addObserver(this);
	}
	public void update(Observable o, Object arg) {
		if(o instanceof Weather){
			Weather weather = (Weather) o;
			showYourVoice(weather.getStatus() + " -- pull");
		}
	}
	
	public void showYourVoice(String status){
		System.out.println("I am a tourist and the weather is " + status);
	}

}
