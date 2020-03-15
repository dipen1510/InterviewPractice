package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPractice {

	public static void main(String[] args) {
		/*
		 * Compress String
		 */
		System.out.println(compressString("abcccddeeeeea"));
		
		/*
		 * Walmart phone string question json parser
		 */
		/*
		 * Input: {"orderNo":1234,"orderName":"abc","itemOrdered":[{"itemId":"wtch123","itemprice":299.99},"itemId":"iphone11","itemprice":999.99}]}
		 * Output:
				{   
				    "orderNo":1234,
				    "orderName":"abc",
				    "itemOrdered":
				        [
				            {
				                "itemId":"wtch123",
				                "itemprice":299.99
				            },
				            {
				                "itemId":"iphone11",
				                "itemprice":999.99
				            }
				        ]
				}
		 */

		String input = ""; // input from commected code
		jsonParser(input);
		
		/*
		 * Livongo phone interview quetion
		 * 
		 * Calculate smallest angle between hour and minute hand
		 */
		
		int ans = calculate("13:00");
	    System.out.println("Final Angel : " + ans);
	    
	    /*
	     * Workday Phone interview Quetion
	     * 
	     * 
	     * A website domain like "www.workday.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "workday.com", and at the lowest level, "www.workday.com". When we visit a domain like "www.workday.com", we will also visit the parent domains "workday.com" and "com" implicitly.
	    Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 www.workday.com".
	    We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
	    Example:
	    Input: 
	    ["9001 www.workday.com", "8001 www.google.com"] salary.workday.com workday.com 
	    Output: 
	    ["9001 www.workday.com", "9001 workday.com", "17002 com"]
	    */
	    
	    List<String> input1 = new ArrayList<>();
        input1.add("9001 www.workday.com");
        input1.add("8001 www.google.com");
        domainCount(input1);
        
        /*
         * Salesforce Phone interview Question
         * 
         * String input : "hi/welcome+home" and String[] delimeter: [/ , +, -]
         * String output : "home/welcom+hi"
         * 
         *  reverse the string with delimeter at same position
         *  
         */
	
	}
	
	public static String compressString(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i< str.length(); i++) {
			sb.append(str.charAt(i));
			int count = 1;
			while(i+1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
				count++;
				i++;
			}
			if(count > 1) {
				sb.append(count);
			}
			
		}
		
		return sb.toString();
	}
	
	public static void jsonParser(String input){
        
        int tabCount =0;
        StringBuilder output = new StringBuilder();
        int i=0;
        
        output.append("Output:");
      for(char ch : input.toCharArray()){

          if(ch == '{' || ch == '['){
            
            output.append("\n").append(ch).append("\n");  //Output:\n { \n \t "orderNo":1234, \n
                                                                //
            tabCount++; //1
            while(i != tabCount){
                output.append("\t");
            }
            i=0;
          } else if(ch == ','){
              output.append(ch).append("\n") ;
          } else if(ch == '}' && ch == ']'){
              output.append("\n");
              tabCount--;
              while(tabCount > 0 && i != tabCount){
                output.append("\t");
            }
            i=0;
              output.append(ch).append("\n");
          } else {
              output.append(ch);
          }
      }
    }
	
	public static int calculate(String str){
	    /*
	     *  you can find same problem in geeksforgeeks.
	     *  Math related quetion.
	     */
		
	    if(str.length() == 0)
	      return 0;
	    
	    if(!str.contains(":"))
	      return 0;
	    
	    String[] watch = str.split(":");
	    
	    if(watch.length > 2)
	      return 0;
	    
	    int hour = Integer.valueOf(watch[0])%12;
	    int min = Integer.valueOf(watch[1]);
	    
	    System.out.println("hour : " + hour);
	    //
	    
	    System.out.println("min : " + min);
	    
	    int difference = Math.abs(hour*5-min); // each hour has 5 min
	    
	    System.out.println("Difference : " + difference);
	    
	    int tempAngle = difference*6; // 360 angle / 60 min = 6
	    
	    int finalAngle = 0;
	    
	    if(min > 15 && min < 30){
	     finalAngle =  tempAngle - 10;
	    } else if(min > 30 && min < 45){
	      finalAngle =  tempAngle - 15;
	    } else if(min > 45 && min < 60){
	      finalAngle =  tempAngle - 20;
	    } else {
	      finalAngle = tempAngle;
	    }
	    
	    if(finalAngle > 180)
	      return 360-finalAngle;
	    else
	      return finalAngle;
	  }
	
	public static void domainCount(List<String> input){
        
        // ["9001 www.workday.com", "8001 www.google.com"]
        
        //List<String> output = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>(); // 
        
        
        // createing map of domain and count
        for(int i = 0; i < input.size() ; i++){ // 1 
            String in = input.get(i); // in = "9001 www.workday.com"
            
            String[] saprate = in.split(" "); // assuming space always there
            // 9001 0 www.workday.com 1
            
            
            if(saprate[1].contains(".")){
                
                String[] domains =  saprate[1].split("//."); // www 0 workday 1 com 2
                StringBuilder domain = new StringBuilder(); // workday.com domain.insert(0,domain[len]);
                //domain.insert(0,".");
                
                for(int j = domains.length-1 ; j >= 0; j--){ //workday
                    domain.insert(0,domains[j]); //com // workday.com
                    
                    
                    if(!map.containsKey(domain.toString())){
                        map.put(domain.toString(), Integer.valueOf(saprate[0])); // look again map = com 9001 workday.com = 9001
                    } else {
                        map.put(domain.toString(),map.get(domain.toString())+Integer.valueOf(saprate[0])); //www.workday.com  9001
                    } 
                    if(j != 0){
                        domain.insert(0,"."); //.com
                    }
                }
            }
             else {
                 if(!map.containsKey(saprate[1])){
                        map.put(saprate[1],Integer.valueOf(saprate[0])); // www.workday.com  -  9001
                    }
                else {
                     map.put(saprate[1], map.get(saprate[1]) + Integer.valueOf(saprate[0])); 
                }
             }
        }
        
        map.forEach((k,v) -> System.out.println(k + " : " + v));
        
    }

}
