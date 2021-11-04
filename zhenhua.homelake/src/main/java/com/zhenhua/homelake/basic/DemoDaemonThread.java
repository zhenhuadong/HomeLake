package com.zhenhua.homelake.basic;

class DaemonThread implements Runnable{

	@Override
	public void run() {
		int i =0;
		while(true) {
			System.out.println("DaemonThread : " + i + " - " + Thread.currentThread().getName());
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}	
}

class UserThread implements Runnable{

	@Override
	public void run() {
		int i =0;
		while(i < 5) {
			System.out.println("UserThread : " + i + " - "  + Thread.currentThread().getName());
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}



public class DemoDaemonThread {

	public static void main(String[] args) {
		Thread daemon = new Thread(new DaemonThread());
		Thread user = new Thread(new UserThread());
		daemon.setDaemon(true);
		
		daemon.start();
		user.start();
		//JVM等所有用户线程结束，但是不会等daemon线程结束。
	}

}
