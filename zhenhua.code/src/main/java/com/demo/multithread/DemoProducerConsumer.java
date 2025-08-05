package com.demo.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DemoProducerConsumer {

    public static void main(String[] args) {
//        BlockingQueue<String> resource = new ArrayBlockingQueue<>(1);
        Resource<String> resource = new Resource(2);
        Producer p1 = new Producer(resource);
        Producer p2 = new Producer(resource);
        Consumer c = new Consumer(resource);

        new Thread(p1, "producer1").start();
        new Thread(p2, "producer2").start();
        new Thread(c,"consumer").start();
    }


    static class Resource<E> {

        final Object[] items;
        int count;
        int produceIndex;
        int consumeIndex;
        final ReentrantLock lock;
        private final Condition notEmpty;
        private final Condition notFull;

        public Resource(int capacity) {
            this(capacity, false);
        }
        public Resource(int capacity, boolean fair){
            if(capacity < 1){
                throw new IllegalArgumentException();
            }
            this.items = new Object[capacity];
            lock = new ReentrantLock(fair);
            notEmpty = lock.newCondition();
            notFull = lock.newCondition();
        }
        
        public void produce(E e) throws InterruptedException {
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                while (count == items.length)
                    notFull.await();
                final Object[] items = this.items;
                items[produceIndex] = e;
                if (++produceIndex == items.length) produceIndex = 0;
                count++;
                notEmpty.signal();
                System.out.println(Thread.currentThread().getName()+ " - " + e);
            } finally {
                lock.unlock();
            }
        }

        public E consume() throws InterruptedException {
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                while (count == 0)
                    notEmpty.await();
                final Object[] items = this.items;
                E e = (E) items[consumeIndex];
                items[consumeIndex] = null;
                if (++consumeIndex == items.length) consumeIndex = 0;
                count--;
                notFull.signal();
                System.out.println(Thread.currentThread().getName()+ " - " + e);
                return e;
            } finally {
                lock.unlock();
            }
        }
    }

    static class Producer implements Runnable{
        private final Resource<String> resource;

        Producer(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    resource.produce(Thread.currentThread().getName()+i);
//                    System.out.printf("producer - %s\n", Thread.currentThread().getName() + i);
                } catch (InterruptedException e) {
//                    System.out.printf("producer waits - %s\n", Thread.currentThread().getName() + i);
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private final Resource<String> resource;

        Consumer(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while(true){
                try {
                    String value = resource.consume();
//                    System.out.println("consumer - %s".formatted(value));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

}
