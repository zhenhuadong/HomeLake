package com.demo.collection;

import java.util.*;
import java.util.concurrent.*;

public class DemoUnsafeCollection {
    public static void main(String[] args) {
        // unsafe collections: ArrayList, HashMap, HashSet;
//        demoArrayList();
//        demoHashMap();
//        demoHashSet();
        // safe collections:
//        demoSynchronizedSet();
//        demoSynchronizedList();
//        demoSynchronizedMap();
        Map<String, String> map = new ConcurrentHashMap<>();
        Set<String> set = new ConcurrentSkipListSet<>();
        List<String> list = new CopyOnWriteArrayList<>();

    }

    private static void demoSynchronizedSet(){
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < 30; i++) {
            new Thread(
                    () -> {
                        set.add(UUID.randomUUID().toString().substring(0, 8));
                        System.out.println(set);
                    }, String.valueOf(i)
            ).start();
        }
    }
    private static void demoHashSet(){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(
                    () -> {
                        set.add(UUID.randomUUID().toString().substring(0, 8));
                        System.out.println(set);
                    }, String.valueOf(i)
            ).start();
        }
    }
    private static void demoSynchronizedList(){
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(
                    () -> {
                        list.add(UUID.randomUUID().toString().substring(0, 8));
                        System.out.println(list);
                    }, String.valueOf(i)
            ).start();
        }
    }
    private static void demoArrayList(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(
                    () -> {
                        list.add(UUID.randomUUID().toString().substring(0, 8));
                        System.out.println(list);
                    }, String.valueOf(i)
            ).start();
        }
    }
    private static void demoSynchronizedMap(){
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(
                    () -> {
                        map.put(key, UUID.randomUUID().toString().substring(0, 8));
                        System.out.println(map);
                    }, String.valueOf(i)
            ).start();
        }
    }
    private static void demoHashMap(){
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(
                    () -> {
                        map.put(key, UUID.randomUUID().toString().substring(0, 8));
                        System.out.println(map);
                    }, String.valueOf(i)
            ).start();
        }
    }

}
