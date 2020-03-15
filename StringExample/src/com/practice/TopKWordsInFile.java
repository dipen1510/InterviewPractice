package com.practice;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TopKWordsInFile{

	
		public static void main(String[] args) throws FileNotFoundException {
			
			FileInputStream inputStream = null;
			Scanner sc = null;
			Map<String,Integer> map = new HashMap<>();
			List<String> ans= new ArrayList<>();
			PriorityQueue<String> pq = new PriorityQueue<>((s1,s2) -> 
							map.get(s1)==map.get(s2) ? s1.compareTo(s2) : map.get(s2) - map.get(s1));
			
			
			try {
				inputStream = new FileInputStream("D:\\test.txt");
				sc = new Scanner(inputStream);
				
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] ln = line.split("\\s+");
					for(String l : ln) {
						map.put(l, map.getOrDefault(l, 0)+1);
					}
				}
				
				pq.addAll(map.keySet());
				
				for(int i=0;i<10;i++) {
					ans.add(pq.poll());
				}
			}
			finally {
				
					try {
						if(inputStream != null)
							inputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				if(sc != null)
					sc.close();
			}
		}

}
