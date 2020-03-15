package com.example.icimsdatamanipulationdemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class IcimsDataManipulationDemo1Application implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(IcimsDataManipulationDemo1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(IcimsDataManipulationDemo1Application.class, args);
	}
	
	@Override
    public void run(String[] args) throws IOException {

		URL url = new URL("https://gist.githubusercontent.com/jed204/92f90060d0fabf65792d6d479c45f31c/raw/346c44a23762749ede009623db37f4263e94ef2a/java2.json");
			JsonFactory jsonfactory = new JsonFactory(); //init factory
	        try {
	            
	          //create ObjectMapper instance
	            ObjectMapper objectMapper = new ObjectMapper();

	            //convert json file to map
	            Map<?, ?> map = objectMapper.readValue(url.openStream(), Map.class);
	            
	            //iterate over map entries and print to console
	            for (Map.Entry<?, ?> entry : map.entrySet()) {
	                System.out.print(entry.getKey() + " : ");
	                
	                //checking if map value instance of the Map
	                if(entry.getValue() instanceof Map) {
	                	Map<?,?> firstInnerMap = (Map<?, ?>) entry.getValue();
	                	int totalSent = 0; //total sent count
	    	            int totalRecv = 0; //total recv count
	    	            
	    	            ////iterate over firstInnerMap entries and print to console
	                	for (Map.Entry<?, ?> firstInnerEntry : firstInnerMap.entrySet()) {
	                		
	                		//checking if firstInnerMap value instance of the Map
	                		if(firstInnerEntry.getValue() instanceof Map) {
	                			Map<?,?> secInnerMap = (Map<?, ?>) firstInnerEntry.getValue();
	                			
	                			//counting total sent and recv
	                			totalSent += Integer.valueOf(secInnerMap.get("sent").toString());
	                			totalRecv += Integer.valueOf(secInnerMap.get("recv").toString());
	                		}
	                	}
	                	System.out.print("totalSent : " + totalSent + "  ,  ");
	                	System.out.print("totalRecv : " + totalRecv);
	                	
	                }
	                System.out.println();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}

