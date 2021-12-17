package com.zhenhua.homelake.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
	public static void demoCountDownLatch(String[] tasks){
		ExecutorService pool = Executors.newFixedThreadPool(tasks.length);
		CountDownLatch latch = new CountDownLatch(tasks.length);
		for (String task: tasks) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("task " + task + " start");
					Random random = new Random();
					try {
						Thread.sleep(random.nextInt(20)*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("task " + task + " done");
					latch.countDown();
					System.out.println("task " + task + " latch=" + latch.getCount());
				}
				
			});
		}
		
		try {
			System.out.println("waiting .... ");
			latch.await();
			System.out.println("waiting .... done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("pool shutdown start");
		pool.shutdown();
		System.out.println("pool shutdown done");
	}
	
	public static void demoCountDownLatch2(String[] tasks){
		ExecutorService pool = Executors.newFixedThreadPool(tasks.length);
		CountDownLatch latch = new CountDownLatch(tasks.length);
		for (String task: tasks) {
			pool.execute(new Worker(task, latch));
		}
		try {
			System.out.println("waiting .... ");
			latch.await();
			System.out.println("waiting .... done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("pool shutdown start");
		pool.shutdown();
		System.out.println("pool shutdown done");
	}
	
	public static void main(String[] args) {
		String[] tasks= {"first", "second", "third"};
		demoCountDownLatch(tasks);
		
		demoCountDownLatch2(tasks);
	}
}

class Worker implements Runnable {
	private String task;
	private CountDownLatch latch;
	public Worker(String task, CountDownLatch latch) {
		this.task = task;
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("task " + task + " start");
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(20)*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task " + task + " done");
		latch.countDown();
		System.out.println("task " + task + " latch=" + latch.getCount());
	}
}
