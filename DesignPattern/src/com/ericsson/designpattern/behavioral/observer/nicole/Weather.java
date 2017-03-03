package com.ericsson.designpattern.behavioral.observer.nicole;

import java.util.Observable;

public class Weather extends Observable {

	private String status = null;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		setChanged();
		notifyObservers(status + " -- push");
	}
	public Weather(String status){
		this.status=status;
	}
}
