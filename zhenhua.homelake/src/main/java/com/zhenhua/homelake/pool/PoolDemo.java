package com.zhenhua.homelake.pool;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.apache.commons.pool2.impl.GenericObjectPool;

public class PoolDemo {
	public static final String fileName = "Pool.txt";
    public static void main( String[] args ) throws IOException{

    	prepare();
    	testReaderUtilWithoutPool();
    	testReaderUtilWithPool();
    	cleanup();
    }


    private static void cleanup() {

    	File file = new File(fileName);
    	file.delete();
	}


	private static void prepare() throws IOException {
    	Writer writer = new FileWriter(fileName);
    	writer.write("hello world!");
    	writer.close();
	}


	public static void testReaderUtilWithoutPool() throws IOException{

    	Reader in = new FileReader(fileName);
    	ReaderUtilWithoutPool readerUtil = new ReaderUtilWithoutPool();
    	String result = readerUtil.readToString(in);
    	System.out.println(result);
    }


    public static void testReaderUtilWithPool() throws IOException{
    	Reader in = new FileReader(fileName);
    	ReaderUtilWithPool readerUtil = new ReaderUtilWithPool(new GenericObjectPool<StringBuffer>(new StringBufferFactory()));
    	String result = readerUtil.readToString(in);
    	System.out.println(result);

    }
}
