package com.zhenhua.homelake.classloader;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

/*
 * add VM argments:
 * -javaagent:"C:\work\code\github\HomeLake\zhenhua.homelake\src\main\java\com\zhenhua\homelake\classloader\Agent.jar" 
*/

public class ClassLoaderDemo {
	final static Logger logger = Logger.getLogger(ClassLoaderDemo.class);

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		ClassLoaderDemo cld = new ClassLoaderDemo();
		cld.printClassLoaders();

	}
	
	
	public void printClassLoaders() throws ClassNotFoundException {
		
		// $JAVA_HOME/jre/lib
	    System.out.println("bootstrap class path: ");
		URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
	    for (int i = 0; i < urls.length; i++) {
	      System.out.println(urls[i]);
	    }
	    
	    // $JAVA_HOME/lib/ext
	    System.out.println("extenions class path: " + System.getProperty("java.ext.dirs"));
		
	    // classpath specify by -classpath or -cp
		System.out.println("system class path: " + System.getProperty("java.class.path"));

		// sun.misc.Launcher$AppClassLoader@18b4aac2
	    System.out.println("Classloader of this class: "
	        + ClassLoaderDemo.class.getClassLoader());

	    //sun.misc.Launcher$ExtClassLoader@4617c264
	    System.out.println("Classloader of parent class:"
		        + ClassLoaderDemo.class.getClassLoader().getParent());

	    System.out.println("Classloader of ArrayList:"
	        + ArrayList.class.getClassLoader());
	    
        printClassesLoadedBy("=== BOOTSTRAP ===");
        printClassesLoadedBy("=== SYSTEM ===");
        printClassesLoadedBy("=== EXTENSION ===");
        
        // default context classloader of thread
        ClassLoader originalClassLoader = Thread.currentThread().getContextClassLoader();
	    System.out.println("original Classloader of thread: " + originalClassLoader);
        try {
            Thread.currentThread().setContextClassLoader(new CustomClassLoader());
            System.out.println("current Classloader of thread: " + Thread.currentThread().getContextClassLoader());
        } finally {
            Thread.currentThread().setContextClassLoader(originalClassLoader);
        }
        System.out.println("current Classloader of thread: " + Thread.currentThread().getContextClassLoader());
	}

    private static void printClassesLoadedBy(String classLoaderType) {
        System.out.println(classLoaderType + " ClassLoader : ");
        Class<?>[] classes = ListLoadedClassesAgent.listLoadedClasses(classLoaderType);
        Arrays.asList(classes)
            .forEach(clazz -> System.out.println(clazz.getCanonicalName()));
    }
}


