package com.practice;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(LCSub("JavaCode2Blog" , "CoreJavaBlogCode"));
	}
	
	public static String LCSub(String str1, String str2) {
		
		int l1 = str1.length();
		int l2 = str2.length();
		int dp[][] = new int[l1][l2];
		
		int max = 0;
		int endIndex = -1;
		
		for(int i=0; i< l1; i++) {
			for(int j=0;j<l2;j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					if(i == 0 || j==0) {
						dp[i][j] =1;
					}else {
						dp[i][j] = dp[i-1][j-1]+1;
					}
					if(max < dp[i][j]) {
						max = dp[i][j];
						endIndex = i;
					}
				}
			}
		}
		
		
		return str1.substring(endIndex-max+1, endIndex+1);
	}

}
