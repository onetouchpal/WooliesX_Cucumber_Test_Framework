package com.cucumberFramework.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public  class CommonHelper {
	
	public String dateFormat(Object date) {
		
	Date date1 = new Date((Integer)date*1000L);
	DateFormat format = new SimpleDateFormat("EEE, MMM d, ''yy");
	 format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted = format.format(date1);
        //System.out.println(formatted);
        format.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        formatted = format.format(date1);
        //System.out.println(formatted);
        return formatted;
	}

}
