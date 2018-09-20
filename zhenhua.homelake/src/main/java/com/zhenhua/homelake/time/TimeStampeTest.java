package com.zhenhua.homelake.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampeTest {
	
	public static void main(String... args){
		getTimeStamp();
		
	}
	
	public static String getTimeStamp() {
		
		Date expirationDate = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		
        String dateString = sdf.format(expirationDate);
		
        System.out.println(dateString);
        
        return dateString;
	}

}