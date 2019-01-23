package com.zhenhua.homelake.multithread.simple;

public class Main {

	public static void main(String[] args) {
		startThread();
		startRunner();
		startLamdaThread();
	}

	private static void startRunner() {
		new Thread(new RunnableExample()).start();
		new Thread(new RunnableExample()).start();	
	}

	private static void startThread() {
		new ThreadExample().start();
		new ThreadExample().start();
	}
	
	private static void startLamdaThread() {
		
		Runnable runner = () -> {
			for(int i=0; i<5; i++) {
				System.out.println("Runnable lamda - " +  i + " Thread: " + Thread.currentThread().getName());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		new Thread(runner).start();
		
		new Thread(() -> {
			for(int i=0; i<5; i++) {
				System.out.println("Thread lamda - " +  i + " Thread: " + Thread.currentThread().getName());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
	}

}
