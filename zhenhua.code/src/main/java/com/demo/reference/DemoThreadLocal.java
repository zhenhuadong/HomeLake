package com.demo.reference;

import java.util.concurrent.*;
public class DemoThreadLocal {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        inheritableThreadLocal.set("parent - inheritableThreadLocal");
        threadLocal.set("parent - threadLocal");
        System.out.println("main thread start: inheritableThreadLocal - " + inheritableThreadLocal.get());
        System.out.println("main thread start: threadLocal - " + threadLocal.get());
//        new Thread(
//                () -> {
//                    System.out.println("Child thread: inheritableThreadLocal - " + inheritableThreadLocal.get());
//                    System.out.println("Child thread: threadLocal - " + threadLocal.get());
//                }
//        ).start();
//        System.out.println("main thread end: inheritableThreadLocal - " + inheritableThreadLocal.get());
//        System.out.println("main thread end: threadLocal - " + threadLocal.get());
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        Executor executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            String name = String.valueOf(i);
            Thread t = new Thread(
                    () -> {
                        threadLocal.set("Child %s - threadLocal - ".formatted(name) + Thread.currentThread().getName());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println( Thread.currentThread().getName() + " " + threadLocal.get());
                    }
            );
//            executor.
        }

//        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
//                2,
//                5,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(10),
//                Executors.defaultThreadFactory(),
//                new AbortPolicy()
//        );
////        ExecutorService pool2 = Executors.newCachedThreadPool();
//
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(
//
//            );
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName()+ ":" + threadLocal.get());
//                    threadLocal.set(Thread.currentThread().getName() + " updated");
//                    System.out.println(Thread.currentThread().getName()+ ":" + threadLocal.get());
//                }
//            });
//        }
//
//        pool.shutdown();


    }
}