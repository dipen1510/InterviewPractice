package com.example.icims_process_application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class IcimsProcessApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(IcimsProcessApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(IcimsProcessApplication.class, args);
	}
	
	@Override
    public void run(String[] args) throws IOException {

		URL url = new URL("https://gist.githubusercontent.com/anonymous/8f60e8f49158efdd2e8fed6fa97373a4/raw/01add7ea44ed12f5d90180dc1367915af331492e/java-data2.json");
			JsonFactory jsonfactory = new JsonFactory(); //init factory
	            
	          //create ObjectMapper instance
	            ObjectMapper objectMapper = new ObjectMapper();

	            //read json file and convert to customer object
	            Items items = objectMapper.readValue(url.openStream(), Items.class);

	            //create MD5Process instance
	            MD5Process md5Hash = new MD5Process(items.items);
	            	
	            //create ExecutorService instance
	            ExecutorService executeService = Executors.newFixedThreadPool(10);

	            //execute ExecutorService
	            for(int i=0; i < 10; i++) {
	            	executeService.execute(new ReadThread(md5Hash));
	            }
	            
	            //shutdown ExecutorService
	            executeService.shutdown();
	            
	            
	  
	}

}
