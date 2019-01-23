package com.zhenhua.homelake.multithread.simple;

public class RunnableExample implements Runnable {

	@Override
	public void run() {
		
		for(int i=0; i<5; i++) {
			System.out.println("RunnableExample - " +  i + " Thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}

}
