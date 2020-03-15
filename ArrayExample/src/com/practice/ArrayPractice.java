package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ArrayPractice {

	public static void main(String[] args) {
		
/*
 * find the pair of elements from array whose sum equals target leetcode 560
 */
		int[] A = { 8, 7, 2, 5, 3, 1 };
		int sum = 10;

		findPair(A, sum); 

/*
 * find subArray with zero sum
 */
		
		int[] A1 = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

		if (zeroSumSubarray(A1)) {
			System.out.println("Subarray exists");
		} else {
			System.out.println("Subarray do not exist");
		}
		
/*
 *  print all subArray with zero sum
 */
		printallSubarrays(A1);
		
/*
* Three way partitions in array
*/
		
		int A4[] = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };

		threeWayPartition(A, A.length - 1);
		System.out.println(Arrays.toString(A4));
		
/*
 *  Majority elements in array		
 */
		int[] arr = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };

		System.out.println("Majority element is " + majorityElement(arr));
		
		
/*
 * 		Find the single duplicate elements from array
 */
		int[] A5 = { 1, 2, 3, 4, 4 };

		System.out.println("Duplicate element is " + findDuplicate(A5));

/*
 * Second heighest value from array
 */
		int[] A6 = {7,5,6,1,4,2};
		int secondHighest=findSecondLargestNumberInTheArray(A6);
		System.out.println("Second largest element in the array : "+ secondHighest);
		
		
/*
 * other Quetions
 * 1. find the duplicate elements from array (use Tortoise and Hare alogo or make element negative and if not duplicate)
 * 2. find all the duplicate elements leetcode 442
 * 3. plus one Leetcode 66
 * 4. best time to buy and sell stock I and II leetcode 121, 122
 * 5. find peak elements leetcode 162
 * 6. Product of Array Except Self leetcode 238
 * 7. Subarray Product Less Than K leetcode 713
 * 8. Maximum Length of Repeated Subarray leetcode 718
 * 9. Reduce Array Size to The Half leetcode 1338
 * 10.  
 */

	}
	
	public static int findSecondLargestNumberInTheArray(int[] arr) {
		int heighst = Integer.MIN_VALUE;
		int secondHeighst = Integer.MIN_VALUE;
		
		for(int i=0; i < arr.length ;i++) {
			if(arr[i] > heighst) {
				
				secondHeighst = heighst;
				heighst = arr[i];
			}else if(arr[i] > secondHeighst && arr[i] != heighst) {
				secondHeighst = arr[i];
			}
		}
		return secondHeighst;
	}
		
	public static int findDuplicate(int[] A)
	{
		int xor = A[0];

		// take xor of all array elements
		for (int i = 1; i < A.length; i++) {
			xor ^= A[i];
		}

		// take xor of numbers from 1 to n-1
		for (int i = 1; i <= A.length - 1; i++) {
			xor ^= i;
		}

		// same elements will cancel out each other as a ^ a = 0,
		// 0 ^ 0 = 0 and a ^ 0 = a

		// xor will contain the missing number
		return xor;
	}

	
	public static int majorityElement(int[] arr) {
		int m = -1;
		int i =0;
		
		for(int j =0; j<arr.length; j++) {
			if(i == 0) {
				m = arr[j];
				i =1;
			} else if (m == arr[j]) {
				i++;
			} else {
				i--;
			}
		}

		return m;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void threeWayPartition(int[] arr, int len) {
		int start =0, mid =0, end = len;
		int pivot = 1;
		
		while(mid <= end) {
			if(arr[mid] < pivot) {
				swap(arr,start,mid);
				mid++;
				start++;
			} else if(arr[mid] > pivot) {
				swap(arr, mid, end);
				end--;
			} else {
				mid++;
			}
		}
	}
	
	public static void printallSubarrays(int[] arr) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		map.put(0, new ArrayList<>());
		map.get(0).add(-1);
		int sum = 0;
		int i=0;
		for(int val : arr) {
			sum += val;
			if(map.containsKey(sum)) {
				List<Integer> temp = map.get(sum);
				for(Integer value : temp) {
					System.out.println(value+1 + " and " + i);
				}
				
			} else {
				map.put(sum, new ArrayList<>());
				
			}
			map.get(sum).add(i);
			i++;
			
		}
		
	}
	
	public static boolean zeroSumSubarray(int[] arr) {
		Set<Integer> ans = new HashSet<Integer>();
		ans.add(0); // handle 0
		int sum =0;
		for(int val : arr) {
			sum += val;
			if(ans.contains(sum)) {
				return true;
			}
			
			ans.add(sum);
		}
		return false;
	}
	
	public static void findPair(int[] arr, int sum) {
		Map<Integer,Integer> map = new HashMap<>();
		int i =0;
		for(int val : arr) {
			if(map.containsKey(sum - val)) {
				System.out.println(map.get(sum-val) + " and " + i++);
				
			} else {
				map.put(val,i);
				i++;
			}
		}
	}

}
