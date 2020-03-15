package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackingPractice {

	public static void main(String[] args) {
		/*
		 * for backtractin go to below leetcode link
		 * 
		 * https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
		 */
		/*
		 * Combination Sum no duplicate combination from leetcode
		 */
		
				int[] candidates = new int[] {2,3,5};
				int target = 8;
				
				List<List<Integer>> ans = combinationSum(candidates, target);
				for(int i =0;i < ans.size(); i++) {
					System.out.println(ans.get(i));
				}
				
		/*
		 * Combination Sum II No duplicate elements and combination
		 */
				
				int[] arr = new int[] {10,1,2,7,6,1,5};
				List<List<Integer>> res = combinationSum2(arr, target);
				for(int i =0;i < res.size(); i++) {
					System.out.println(res.get(i));
				}
				
		/*
		 * Permutaion
		 */
				int[] nums = new int[] {1,2,3};
				List<List<Integer>> res1 = permutaion(nums);
				for(int i =0;i < res1.size(); i++) {
					System.out.println(res1.get(i));
				}
				
		/*
		 * Permutaion with dulicate elements
		 */
				int[] nums1 = new int[] {1,2,1};
				List<List<Integer>> res2 = permutaionDup(nums1);
				for(int i =0;i < res2.size(); i++) {
					System.out.println(res2.get(i));
				}
			}
			
			public static List<List<Integer>> permutaionDup(int[] arr){
				List<List<Integer>> res = new ArrayList<>();
				Arrays.sort(arr);
				boolean visited[] = new boolean[arr.length];
				permutaionDupBacktrack(arr,res, new ArrayList<>(),visited);
				return res;
			}
			
			public static void permutaionDupBacktrack(int[] candidates, List<List<Integer>> res,
					List<Integer> temp, boolean[] visited) {
				if(temp.size() == candidates.length) {
					res.add(new ArrayList<>(temp));
				}else{
					for(int i = 0; i < candidates.length; i++) {
						if(visited[i] || (i>0 && candidates[i] == candidates[i-1] && !visited[i-1]))
							continue;
						visited[i] = true;
						temp.add(candidates[i]);
						permutaionDupBacktrack(candidates,res,temp, visited);
						visited[i]=false;
						temp.remove(temp.size()-1);
					}
				}
			}
			
			public static List<List<Integer>> permutaion(int[] arr){
				List<List<Integer>> res = new ArrayList<>();
				permutaionBacktrack(arr,res, new ArrayList<>());
				return res;
			}
			
			public static void permutaionBacktrack(int[] candidates, List<List<Integer>> res,
					List<Integer> temp) {
				if(temp.size() == candidates.length) {
					res.add(new ArrayList<>(temp));
				}else{
					for(int i = 0; i < candidates.length; i++) {
						if(temp.contains(candidates[i]))
							continue;
						temp.add(candidates[i]);
						permutaionBacktrack(candidates,res,temp);
						temp.remove(temp.size()-1);
					}
				}
			}
			
			public static List<List<Integer>> combinationSum2(int[] arr, int target){
				List<List<Integer>> res = new ArrayList<>();
				Arrays.sort(arr);
				combinationBacktrack2(arr,target,res, new ArrayList<>(), 0);
				return res;
			}
			
			public static void combinationBacktrack2(int[] candidates, int target, List<List<Integer>> res,
					List<Integer> temp, int start) {
				if(target < 0)
					return;
				else if(target == 0) {
					res.add(new ArrayList<>(temp));
				}else{
					for(int i = start; i < candidates.length; i++) {
						if(i>start && candidates[i] == candidates[i-1])
							continue;
						temp.add(candidates[i]);
						combinationBacktrack2(candidates,target-candidates[i],res,temp,i+1);
						temp.remove(temp.size()-1);
					}
				}
			}
			
			public static List<List<Integer>> combinationSum(int[] candidates, int target){
				List<List<Integer>> res = new ArrayList<>();
				combinationBacktrack(candidates,target,res, new ArrayList<>(), 0);
				return res;
			}
			
			public static void combinationBacktrack(int[] candidates, int target, List<List<Integer>> res,
					List<Integer> temp, int start) {
				
				if(target < 0)
					return;
				else if(target == 0) {
					res.add(new ArrayList<>(temp));
				}else{
					for(int i = start; i < candidates.length; i++) {
						temp.add(candidates[i]);
						combinationBacktrack(candidates,target-candidates[i],res,temp,i);
						temp.remove(temp.size()-1);
					}
				}
			}

}
