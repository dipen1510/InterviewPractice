package com.practice;

import java.util.Stack;

public class StackPractice {

	public static void main(String[] args) {
		
		/*
		 * postfi evaluation of string
		 */
		String exp = "138*+";
		System.out.println(postfixEval(exp));
		
		/*
		 * Other Quetions
		 * 1. basic Calulator leetcode
		 * 2. parentheses related
		 */
	}
	
	public static int postfixEval(String exp) {
		Stack<Integer> st = new Stack<>();
		for(Character c : exp.toCharArray()) {
			
			if(!c.isDigit(c) && st.size() >= 2) {
				int x = st.pop();
				int y = st.pop();
				if(c == '+') {
					st.push(y + x);
				}
				else if(c == '*') {
					st.push(y * x);
				}
				else if(c == '/' && x > 0) {
					st.push(y/x);
				}
				else if(c == '-') {
					st.push(y - x);
				}
				
			} else {
				st.push(c - '0');
			}
		}
		
		if(st.size() == 1)
			return st.pop();
		else 
			return -1;
	}

}
