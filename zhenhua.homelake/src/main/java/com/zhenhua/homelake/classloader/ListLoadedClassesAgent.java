package com.zhenhua.homelake.classloader;

import java.lang.instrument.Instrumentation;
/**
 * 
 * @author ezhendo
 *
 *  cd .\src\main\java\com\zhenhua\homelake\classloader
 *  javac ListLoadedClassesAgent.java
 *  jar cvf Agent.jar ListLoadedClassesAgent.class
 *  jar cvmf MANIFEST.MF Agent.jar ListLoadedClassesAgent.class
 *  
 */


public class ListLoadedClassesAgent {
    private static Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        ListLoadedClassesAgent.instrumentation = instrumentation;
    }
    
    public static Class<?>[] listLoadedClasses(String classLoaderType) {
        return instrumentation.getInitiatedClasses(
          getClassLoader(classLoaderType));
    }
    
    private static ClassLoader getClassLoader(String classLoaderType) {
        ClassLoader classLoader = null;
        switch (classLoaderType) {
            case "SYSTEM":
                classLoader = ClassLoader.getSystemClassLoader();
                break;
            case "EXTENSION":
                classLoader = ClassLoader.getSystemClassLoader().getParent();
                break;
            case "BOOTSTRAP":
                break;
            default:
                break;
        }
        return classLoader;
    }
}
