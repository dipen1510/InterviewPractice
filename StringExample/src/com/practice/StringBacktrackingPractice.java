package com.practice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringBacktrackingPractice {
	
	static List<String> output = new ArrayList<>();
	
	static Map<String, String> phone = new HashMap<String,String>() {{
        put("2", "abc");
   put("3", "def");
   put("4", "ghi");
   put("5", "jkl");
   put("6", "mno");
   put("7", "pqrs");
   put("8", "tuv");
   put("9", "wxyz");
   }};

	public static void main(String[] args) {
		
		/*
		 * Longest Palindromic substring 
		 */
		String str = "ABDCBCDBDCBBC";

		System.out.println("Longest Palindromic SubString of " + str + " is "
				+ LongestPalindromicSubString(str, str.length() - 1));
		
		/*
		 * All palindromic substrings
		 */
		String str1 = "google";

		allPalindromicSubStrings(str);
		
		
	    /*
	     * letter combination of phone digit
	     */
	    
	    letterCombinations("234");
	    
	    /*
	     * String permutation backtracking
	     */
	    
	    String s = "ABC";
		permutations(s, s.length(), new ArrayList<>(),0);
		

	}
	
	public static String swap(String s, int start, int end) {
		char temp; 
        char[] charArray = s.toCharArray(); 
        temp = charArray[start] ; 
        charArray[start] = charArray[end]; 
        charArray[end] = temp; 
        return String.valueOf(charArray);
		
	}
	
	public static void permutations(String s, int len, List<String> ans, int start) {
		if(start == len-1) {
			System.out.println(s);
			ans.add(s);
		}else {
			for(int i =start; i<len; i++) {
				s = swap(s,start,i);
				permutations(s,len, ans, start+1);
				s = swap(s, start, i);
			}
		}
	}
	
	public static void letterCombinations(String digits) {
		
		if(digits.length() != 0) {
			backtracking("", digits);
		}
		System.out.println(output);
	}
	
	public static void backtracking(String combination, String digits) {
		if(digits.length() == 0) {
			output.add(combination);
		}else {
			String digit = digits.substring(0, 1);
			String letters = phone.get(digit);
			for(int i=0; i<letters.length(); i++) {
				String letter = phone.get(digit).substring(i, i+1);
				backtracking(combination+letter, digits.substring(1));
			}
		}
	}
	
	public static String LongestPalindromicSubString(String str, int len) {
		int maxLength = Integer.MIN_VALUE;
		int start =0, end =0;
		for(int i=0; i< len;i++) {
			maxLength = Math.max(expand(str,i,i), expand(str,i,i+1));
			if(maxLength > end-start) {
				start = i - (maxLength -1)/2;
				end = i + (maxLength/2);
			}
		}
		
		return str.substring(start,end);
	}
	
	public static int expand(String str, int first, int sec) {
		while(first >= 0 && sec <= str.length()-1 && str.charAt(first) == str.charAt(sec)) {
				first--;
				sec++;
		}
		return sec-first;
	}
	
	public static void expand1(String str, int first, int sec, Set<String> ans) {
		while(first >= 0 && sec <= str.length()-1 && str.charAt(first) == str.charAt(sec)) {
			ans.add(str.substring(first, sec+1));	
			first--;
			sec++;
		}
	}
	
	public static void allPalindromicSubStrings(String str) {
		Set<String> ans = new HashSet<>();
		for(int i=0; i< str.length();i++) {
			expand1(str,i,i,ans);
			expand1(str,i,i+1,ans);
		}
		System.out.println(ans);
	}

}
