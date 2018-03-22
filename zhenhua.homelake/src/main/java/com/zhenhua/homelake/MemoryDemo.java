package com.zhenhua.homelake;

/**
 * Hello world!
 *
 */
public class MemoryDemo 
{
    public static void main( String[] args ){
    	System.out.println("Hello World");
//    	stackOverflow(0);
    	heapOutOfMemory(0);
    }
    
    
    public static void stackOverflow(int i){
    	if(i%10 == 0){
    		System.out.println(i);
    	}
//    	try {
    		stackOverflow(++i);
//    	}catch (StackOverflowError e) {
//    		System.out.println(i);
////    		e.printStackTrace();
//    		throw new RuntimeException();
//    	}
    }
    
    public static void heapOutOfMemory(int i){
    	StringBuffer sb = new StringBuffer();
    	for(int j=0; j<1024*1024; j++){
    		sb.append("a");
    	}
    	
//    	if(i%10 == 0){
//    		System.out.println(i);
//    	}
    	try {
    		heapOutOfMemory(++i);
    	} catch (OutOfMemoryError e) {
    		System.out.println(i);
    		e.printStackTrace();
    		throw new RuntimeException();
    	}
    	System.out.println(sb.toString());
    }
    
}
