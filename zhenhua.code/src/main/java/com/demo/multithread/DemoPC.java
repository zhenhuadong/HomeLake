package com.demo.multithread;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DemoPC {

    public static void main(String[] args) {

        Resource<String> resource = new Resource<>(2, true);
        Producer p = new Producer(resource);
        Consumer c = new Consumer(resource);
//        Thread p1 = new Thread(p, "producer1");
//        Thread p2 = new Thread(p, "producer2");
//        Thread c1 = new Thread(c, "consumer1");
//        Thread c2 = new Thread(c, "consumer2");
//        p1.start();
//        p2.start();
//        c1.start();
//        c2.start();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,
                8,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                new MyThreadFactory("demo"),
                new ThreadPoolExecutor.AbortPolicy());
        executor.submit(p);
        executor.submit(p);
        executor.submit(c);
        executor.submit(c);

        executor.shutdown();
        try {
            System.out.println("wait 5 more second");
            if(!executor.awaitTermination(5, TimeUnit.SECONDS)){
                System.out.println("shutdown now");
                List<Runnable> list = executor.shutdownNow();
                System.out.println(list);
            }
        } catch (InterruptedException e) {
            System.out.println("shutdown now 2");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    static class Resource<E> {

        final int capacity;
        final Object[] items;
        private int produceIndex;
        private int consumeIndex;
        private int count;

        final ReentrantLock lock;
        final Condition notFull;
        final Condition notEmpty;

        Resource(int capacity) {
            this(capacity, false);
        }
        Resource(int capacity, boolean fair) {
            if(capacity < 1){
                throw new IllegalArgumentException("capacity must be positive integer");
            }
            this.capacity = capacity;
            items = new Object[capacity];
            lock = new ReentrantLock(fair);
            notFull = lock.newCondition();
            notEmpty = lock.newCondition();
        }

        public void produce(E e) throws InterruptedException {
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try{
                while(count == items.length){
                    System.out.println(Thread.currentThread().getName() + " - wait");
                    notFull.await();
                }
                final Object[] items = this.items;
                items[produceIndex] = e;
                produceIndex = (++produceIndex) % capacity;
                ++count;
                System.out.println(Thread.currentThread().getName() + " - " + e);
                notEmpty.signalAll();
            }finally {
                lock.unlock();
            }

        }

        public E consume() throws InterruptedException {
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                while(count == 0){
                    System.out.println(Thread.currentThread().getName() + " - wait");
                    notEmpty.await();
                }
                final Object[] items = this.items;
                E e = (E) items[consumeIndex];
                items[consumeIndex] = null;
                consumeIndex = (++consumeIndex) % capacity;
                --count;
                System.out.println(Thread.currentThread().getName() + " - " + e);
                notFull.signalAll();
                return e;
            } finally {
                lock.unlock();
            }
        }

    }

    static class Producer implements Runnable{
        private Resource<String> resource;

        public Producer(Resource<String> resource){
            this.resource = resource;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.produce(Thread.currentThread().getName()+ " - " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class Consumer implements Runnable{
        private Resource<String> resource;
        public Consumer(Resource<String> resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    resource.consume();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }


}
