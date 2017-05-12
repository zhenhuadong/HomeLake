package com.zhenhua.homelake.pool;

import java.io.IOException;
import java.io.Reader;

public class ReaderUtilWithoutPool {
	
	public ReaderUtilWithoutPool() {};

	public String readToString(Reader in) throws IOException{
		StringBuffer buf = new StringBuffer();
		
		try {
			for(int c = in.read(); c!=-1; c=in.read()){
				buf.append((char)c);
			}
			
			return buf.toString();
		} catch (IOException e) {
			e.printStackTrace();
			// log debug : IO exception
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				//log info : Reader close issue
			}
		}
		
	}
}
