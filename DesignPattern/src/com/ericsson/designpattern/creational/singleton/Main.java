package com.ericsson.designpattern.creational.singleton;

public class Main {


	
	public static void main(String[] args) {
		
//		testSingleton(0, "one thread");
		
		for(int i=0; i<10; i++){
			new ThreadTypeOne(i).start();
//			new Thread(new ThreadTypeTwo(i)).start();
		}

/*
 * Test result:
 *  SingletonTwo, not multi-threads safe
 *  others, multi-threads safe 
 */
	}
	

	static class ThreadTypeOne extends Thread{
		public int threadId = 0;
		public ThreadTypeOne(int threadId){
			this.threadId = threadId;
		}
		public void run(){
			testSingleton(threadId, "typeOne");
		}
	}
	
	static class ThreadTypeTwo implements Runnable{
		public int threadId = 0;
		public ThreadTypeTwo(int threadId){
			this.threadId = threadId;
		}
		public void run(){
			testSingleton(threadId, "typeTwo");
		}
	}
	
	private static void testSingleton(int threadId, String type){
		System.out.println(SingletonOne.getInstance() + " SingletonOne id =" + threadId + " type=" + type );
		System.out.println(SingletonOne.getInstance()+ " SingletonOne id =" + threadId + " type=" + type);

		System.out.println(SingletonTwo.getInstance()+ " SingletonTwo id =" + threadId + " type=" + type);
		System.out.println(SingletonTwo.getInstance()+ " SingletonTwo id =" + threadId + " type=" + type);

		System.out.println(SingletonThree.getInstance()+ " SingletonThree id =" + threadId + " type=" + type);
		System.out.println(SingletonThree.getInstance()+ " SingletonThree id =" + threadId + " type=" + type);

		System.out.println(SingletonFour.getInstance()+ " SingletonFour id =" + threadId + " type=" + type);
		System.out.println(SingletonFour.getInstance()+ " SingletonFour id =" + threadId + " type=" + type);

		System.out.println(SingletonFive.getInstance()+ " SingletonFive id =" + threadId + " type=" + type);
		System.out.println(SingletonFive.getInstance()+ " SingletonFive id =" + threadId + " type=" + type);
	}

}
