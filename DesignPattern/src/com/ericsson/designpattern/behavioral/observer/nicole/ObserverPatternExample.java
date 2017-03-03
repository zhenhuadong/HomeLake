package com.ericsson.designpattern.behavioral.observer.nicole;

public class ObserverPatternExample {

	/**
	 * Oberser design pattern:
	 *  1. one Subject interface and one Concrete subject has the status
	 *  2. one Observer interface and one concrete observer
	 *  3. Observer constructor has one Subject, and subject.register(this).
	 *  4. subject manage the observer list and notifyObserver if status change 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Weather weather = new Weather("sunny");
		
		Student student = new Student(weather);
		Tourist tourist = new Tourist(weather);
		
		weather.setStatus("rain");
	}

}
