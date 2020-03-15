package com.multithread;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Map;

public class HashMapImpl {
	
	public static void main(String[] args) {
		String newDateString = null;
        System.out.println("Hello World!");
        
       // try {
        	String gitUrl = "https://github.pie.apple.com/Honeycomb-QA/devops-dashboard";
        	String[] gitParam = gitUrl.split("/");
            String gitOwner = gitParam[gitParam.length - 2];
            String gitRepo = gitParam[gitParam.length - 1];
            
            System.out.println(gitOwner + gitRepo);
        	//}
//           Timestamp t = Timestamp.valueOf("2019-11-21 23:28:46");
//        	    SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-YY hh.mm.ss aa");
//            System.out.println(outputFormat.format(t));
//            
//            String d = "1232-43-45T54:56:66Z";
//            d = d.replace('T', ' ').replace('Z', ' ');
//            
//            System.out.println(d);
//            
//            
//          } catch (DateTimeParseException e) {
//            System.out.println("Exception :" + e);
//            
          
    }

}

