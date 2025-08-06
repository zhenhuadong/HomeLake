package com.demo.multithread;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
    private final AtomicInteger atomicInteger = new AtomicInteger(1);
    private final String prefix;
    public MyThreadFactory(String prefix){
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(@NotNull Runnable r) {
        return new Thread(r, prefix + atomicInteger.getAndIncrement());
    }
}
