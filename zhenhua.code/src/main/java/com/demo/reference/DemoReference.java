package com.demo.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * https://blog.csdn.net/xlinsist/article/details/57089288
 *
 * /Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/bin/java -Xms8m -Xmx8m -Xlog:gc -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=60482:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/dzh/IdeaProjects/HomeLake/out/production/zhenhua.code:/Users/dzh/Downloads/junit-4.9.jar:/Users/dzh/Downloads/junit-dep-4.9.jar:/Users/dzh/.m2/repository/org/jetbrains/annotations/20.1.0/annotations-20.1.0.jar com.demo.reference.DemoReference
 * [0.004s][info][gc] Using G1
 * Before memory pressure: Person{age=20, name='tom'}
 * Before memory pressure: Person{age=20, name='jerry'}
 * [0.057s][info][gc] GC(0) Pause Young (Concurrent Start) (G1 Humongous Allocation) 2M->1M(8M) 1.585ms
 * [0.057s][info][gc] GC(1) Concurrent Undo Cycle
 * [0.058s][info][gc] GC(2) Pause Young (Normal) (G1 Preventive Collection) 1M->1M(8M) 0.637ms
 * [0.058s][info][gc] GC(1) Concurrent Undo Cycle 0.910ms
 * [0.064s][info][gc] GC(3) Pause Full (System.gc()) 5M->5M(8M) 3.079ms
 * In loop gc 0Person{age=20, name='tom'}
 * In loop gc 0 weakRef is null
 * [0.068s][info][gc] GC(4) To-space exhausted
 * [0.068s][info][gc] GC(4) Pause Young (Concurrent Start) (G1 Humongous Allocation) 5M->5M(8M) 0.457ms
 * [0.068s][info][gc] GC(6) Concurrent Mark Cycle
 * [0.071s][info][gc] GC(5) Pause Full (G1 Compaction Pause) 5M->1M(8M) 2.463ms
 * [0.071s][info][gc] GC(6) Concurrent Mark Cycle 2.565ms
 * [0.073s][info][gc] GC(7) Pause Full (System.gc()) 5M->5M(8M) 2.251ms
 * In loop gc 1 softRef is null
 * In loop gc 1 weakRef is null
 * [0.076s][info][gc] GC(8) To-space exhausted
 * [0.076s][info][gc] GC(8) Pause Young (Concurrent Start) (G1 Humongous Allocation) 5M->5M(8M) 1.483ms
 * [0.076s][info][gc] GC(10) Concurrent Mark Cycle
 * [0.078s][info][gc] GC(9) Pause Full (G1 Compaction Pause) 5M->1M(8M) 2.200ms
 * [0.079s][info][gc] GC(10) Concurrent Mark Cycle 2.446ms
 * [0.083s][info][gc] GC(11) Pause Full (System.gc()) 5M->5M(8M) 3.831ms
 * In loop gc 2 softRef is null
 * In loop gc 2 weakRef is null
 * After memory pressure: softRef is null
 * After memory pressure: weakRef is null
 */
public class DemoReference {
    public static void main(String[] args) {
        Person tom = new Person(20, "Soft");
        SoftReference<Person> softRef = new SoftReference<>(tom);

        Person jerry = new Person(20, "Weak");
        WeakReference<Person> weakRef = new WeakReference<>(jerry);
        tom = null;
        jerry = null;

        if(softRef.get() != null){
            System.out.println("Before memory pressure: " + softRef.get());
        } else {
            System.out.println("Before memory pressure: softRef is null");
        }

        if(weakRef.get() != null){
            System.out.println("Before memory pressure: " + weakRef.get());
        } else {
            System.out.println("Before memory pressure: weakRef is null");
        }

        for (int i = 0; i < 3; i++) {
            Integer[] arr = new Integer[1000000];
            System.gc();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(softRef.get() != null){
                System.out.println("In loop gc " + i + softRef.get());
            } else {
                System.out.println("In loop gc " + i + " softRef is null");
            }

            if(weakRef.get() != null){
                System.out.println("In loop gc " + i + weakRef.get());
            } else {
                System.out.println("In loop gc " + i + " weakRef is null");
            }
        }

        if(softRef.get() != null){
            System.out.println("After memory pressure: " + softRef.get());
        } else {
            System.out.println("After memory pressure: softRef is null");
        }

        if(weakRef.get() != null){
            System.out.println("After memory pressure: " + weakRef.get());
        } else {
            System.out.println("After memory pressure: weakRef is null");
        }

    }
}
