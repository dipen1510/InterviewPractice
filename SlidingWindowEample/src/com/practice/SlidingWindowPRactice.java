package com.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindowPRactice {

	public static void main(String[] args) {
		
		/*
		 * Longest substring of given string containing distinct characters
		 */
				String str = "abbcdafeegh";

				System.out.println(longestNonRepetiveSubstr(str));
				
		 /*
		  * Find the longest substring of given string containing k distinct characters
		  */
				String str1 = "abcbdbdbbdcdabd";
				int k = 2;

				System.out.println(longestSubstr(str1, k));
				
		   /*
		    * Find duplicates within given range k in an array
		    */
				int[] arr = { 5, 6, 8, 2, 4, 6, 9 };
				int t = 4;

				if (hasDuplicates1(arr, t) && hasDuplicates2(arr,t)) {
					System.out.println("Duplicates found");
				}
				else {
					System.out.println("No Duplicates found");
				}
				
			/*
			 * Find minimum sum subarray of given size k
			 */
				int[] arr1= { 10, 4, 2, 5, 6, 3, 8, 1 };
				int a = 3;

				findSubarray(arr1, a);
				System.out.println();
				
			/*
			 * Find subarray having given sum in given array of integers
			 */
				
						int[] A = { 0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10 };
						int sum = 15;

						//Count 
						findsumCountSubarray(A, sum); //HashMap Solution for all +/- numbers
						//start & end index
						findSumSubArray(A,sum);
						
				/*
				 * Find the length of smallest subarray whose sum of elements is greater than the given number
				 */

						// array of positive numbers
						int[] B = {1, 2, 3, 4, 5, 6, 7, 8};
						int b = 21;

						// find length of the smallest sub-array
						int len = smallestSubarray(B, b);

						if (len != Integer.MAX_VALUE) {
							System.out.print("Smallest sub-array length is " + len);
						} else {
							System.out.print("No sub-array exists");
						}
				
				/*
				 * Other Questions
				 * 1. Given a string S, return the number of substrings of length K with no repeated characters.
				 */
						
			}
			
			public static int  smallestSubarray(int[] arr, int sum) {
				int temp =0;
				int len = Integer.MAX_VALUE;
				int j=0;
				for(int i=0;i<arr.length;i++) {
					temp += arr[i];
					
					while(temp > sum && j <= i) {
						len = Math.min(len, i-j+1);
						temp -= arr[j];
						j++;
					}
				}
				return len;
			}
			
			public static void findsumCountSubarray(int[] arr, int sum) {
				Map<Integer, Integer> map = new HashMap<>();
				int tempSum = 0;
				map.put(0,-1);
				for(int i=0; i< arr.length; i++) {
					tempSum += arr[i]; 
					
					if(map.containsKey(tempSum-sum)) {
						System.out.println("start & end Index : " + (map.get(tempSum-sum)+1) + " : " + i);
					}
					map.put(tempSum, i);
				}
				
			}
			
			public static void findSumSubArray(int[] arr, int sum) {
				Map<Integer, Integer> map = new HashMap<>();
				int tempSum = 0;
				map.put(0,1);
				int count = 0;
				for(int i=0; i< arr.length; i++) {
					tempSum += arr[i]; 
					
					if(map.containsKey(tempSum-sum)) {
						count += map.get(tempSum-sum);
					}
					map.put(tempSum, map.getOrDefault(tempSum, 0)+1);
				}
				
				System.out.println("Number of times sum occurs in subArray : " + count);
				
			}
			
			public static void findSubarray(int[] arr, int k) {
				int tempSum = 0;
				int minSum = Integer.MAX_VALUE;
				int start =0, end = 0;
				for(int i=0; i < k;i++) {
					tempSum += arr[i];
				}
				int j=0;
				for(int i=k; i<arr.length; i++) {
					if(minSum > tempSum) {
						start = j;
						end = i-1;
						minSum = tempSum;
					}
					//minSum = Math.min(minSum, tempSum);
					tempSum = tempSum - arr[j] + arr[i];
					j++;
				}
				
				System.out.println("minmum Sum: " + minSum);
				System.out.println("start Index : " + start + " end Index : " + end);
				System.out.print("Array Elements :  ");
				for(int i=start;i<=end;i++) {
					System.out.print(arr[i] + " ");
				}
			}
			
			public static boolean hasDuplicates1(int[] arr, int k) {
				Map<Integer,Integer> map = new HashMap<>();
				
				for(int i=0; i < arr.length; i++) {
					if(map.containsKey(arr[i])) {
						if(i - map.get(arr[i]) <= k)
							return true;
					}
					map.put(arr[i], i);
				}
				
				return false;
			}
			
			public static boolean hasDuplicates2(int[] arr, int k) {
				Set<Integer> set = new HashSet<>();
				
				for(int i=0; i < arr.length; i++) {
					if(set.contains(arr[i]))
						return true;
					
					set.add(arr[i]);
					
					if(i >= k)
						set.remove(arr[i-k]);
				}
				
				return false;
			}
			
			public static String longestSubstr(String str, int k) {
				if(str.length() == 0)
					return "";
				if(str.length() < k)
					return str;
				
				Map<Character,Integer> map = new HashMap<>();
				
				int start =0, end =0;
				int i=0, j=0;
				
				while(i < str.length() && j < str.length()) {
					map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);
					if(map.size() <=k) {
						if(end-start < j-i) {
							end =j;
							start =i;
						}
					}
					while(map.size() > k) {
						int temp = map.get(str.charAt(i));
						if(temp == 1)
							map.remove(str.charAt(i));
						else
							map.put(str.charAt(i), map.get(str.charAt(i))-1);
						
						i++;
					}
					
					j++;
				}
				
				return str.substring(start, end+1);
			}
			
			public static String longestNonRepetiveSubstr(String str) {
				Set<Character> set = new HashSet<>();
				int maxLen  = 0;
				int start =0, end = 0;
				int i=0,j=0;
				
				while(i < str.length() && j < str.length()) {
					if(!set.contains(str.charAt(j))) {
						set.add(str.charAt(j++));
						if(end-start < j-i) {
							start = i;
							end = j;
						}
					} else {
							set.remove(str.charAt(i++));
					}
				}
				
				return str.substring(start, end);
			}

}
