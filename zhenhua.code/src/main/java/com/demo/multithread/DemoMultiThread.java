package com.demo.multithread;

import java.util.Random;
import java.util.concurrent.*;

public class DemoMultiThread {
    public static void main(String[] args) {
        Thread myThread = new MyThread("MyThread");
        myThread.start();

        Thread myThread2 = new Thread(
                ()-> {
                    try {
                        Thread.sleep(new Random().nextInt(2));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("This is %s.".formatted(Thread.currentThread().getName()));
                }, "myThread2"
        );
        myThread2.start();

        Thread myThread3 = new Thread(new MyRunnable(), "myThread3");
        myThread3.start();

        FutureTask f = new FutureTask<>(new MyCallable<>(200));
        Thread myThread4 = new Thread(f, "myThread4");
        myThread4.start();

        try {
            System.out.println("myThread4 return %s.".formatted(f.get()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                4,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Future<String> ft1 = executor.submit(
                () -> {
                    System.out.println("This is pool - %s".formatted(Thread.currentThread().getName()));
                    return "pool thread done";
                }
        );

        Future<String> ft2 = executor.submit(new MyCallable<>(300));

        Future<?> ft3 = executor.submit(new MyRunnable());

        try {
            System.out.println("pool thread ft1 return %s.".formatted(ft1.get()));
            System.out.println("pool thread ft2 return %s.".formatted(ft2.get()));
            System.out.println("pool thread ft3 return %s.".formatted(ft3.get()));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }



    static class MyThread extends Thread {
        public MyThread(String name){
            super(name);
        }

        @Override
        public void run(){
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("This is %s.".formatted(Thread.currentThread().getName()));
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("This is %s.".formatted(Thread.currentThread().getName()));
        }
    }

    static class MyCallable<T> implements Callable<T> {
        private int value;
        public MyCallable(int value) {
            this.value = value;
        }

        @Override
        public T call() throws Exception {
            System.out.println("This is %s.".formatted(Thread.currentThread().getName()));
            return (T) String.valueOf(new Random().nextInt(value));
        }
    }

}
