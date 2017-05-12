package com.zhenhua.homelake.pool;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.pool2.ObjectPool;

public class ReaderUtilWithPool {
	
	private ObjectPool<StringBuffer> pool;
	public ReaderUtilWithPool(ObjectPool<StringBuffer> pool){
		this.pool=pool;
	}
	
	
	
	public String readToString(Reader in) throws IOException{
		
		StringBuffer buf = null;
		
		try {
			buf = pool.borrowObject();
			for(int c=in.read(); c != -1 ; c=in.read()){
				buf.append((char)c);
			}
			return buf.toString();
		} catch (IOException e) {
			e.printStackTrace();
			// log debug : IO exception
			throw e;
		} catch (Exception e){
			//log debug : borrowObject from pool exception
			throw new RuntimeException("Unable to borrow buffer from pool" + e.toString());
		} finally {
			
			try {
				in.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				if (null != buf) {
					pool.returnObject(buf);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
