package com.demo.reference;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.*;

import static java.util.concurrent.ThreadPoolExecutor.*;

public class DemoThreadLocal {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10,
                20,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new AbortPolicy()
        );
        ExecutorService pool2 = Executors.newCachedThreadPool();
        Set<String> s = new HashSet<>();
//        Collections.synchronizedList();
//        List<String> l = new ArrayBlockingQueue<>();

        for (int i = 0; i < 1000; i++) {
            pool2.submit(() -> {
                System.out.println("hello ");
                s.add("hello");
                System.out.println("world ") ;
            });
        }

        pool2.shutdown();
        System.out.println("last :" + s);

//        pool.submit()
//        pool.execute(work1);
    }
}