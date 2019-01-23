package com.zhenhua.homelake.multithread.simple;

public class ThreadExample extends Thread {

    @Override
    public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("ThreadExample - " +  i + " Thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


    }
}
