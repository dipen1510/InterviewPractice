package com.practice;

public class BinarySerachPractice {

	public static void main(String[] args) {
		
		/*
		 * rotation count of circular sorted array
		 */
		int[] A1 = { 8, 9, 10, 1, 2, 3, 4, 5, 6, 7 };

		System.out.println("The array is rotated " + findRotationCount(A1) + " times");
		
		/*
		 * circular array search
		 */
		int[] A = {9, 10, 2, 5, 6, 8};
		int key = 5;

		int index = circularArraySearch(A, key);

		if (index != -1) {
			System.out.println("Element found at index " + index);
		} else {
			System.out.println("Element not found in the array");
		}
		
		/*
		 * smallest missing element in sorted array
		 */
		
		int[] B = { 0, 1, 2, 3, 4, 5, 6 };

		int left = 0, right = B.length - 1;
		System.out.println("The smallest missing element is "
							+ smallestMissing(B, left, right));

	}
	
	public static int smallestMissing(int[] A, int left, int right) {
		if(left > right)
			return left;
		int mid = left + (right-left)/2;
		if(A[mid] == mid)
			return smallestMissing(A,mid+1,right);
		else
			return smallestMissing(A,left,mid-1);
	}
	public static int circularArraySearch(int[] A, int key) {
		int left =0;
		int right = A.length-1;
		
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(key == A[mid])
				return mid;
			
			if(A[mid] <= A[right]) {
				if(key > A[mid] && key <= A[right]) {
					left = mid+1;
				}else 
					right = mid-1;
			}else {
				if(key > A[left] && key <= A[mid])
					right = mid-1;
				else
					left = mid+1;
			}
		}
		return -1;
	}
	
	public static int findRotationCount(int[] A) {
		int left = 0;
		int right = A.length-1;
		
		while(left <= right) {
			if(A[left] <= A[right])
				return left;
			
			int mid = left + (right-left)/2;
			int next = (mid+1) % A.length;
			int prev = (mid-1 + A.length) % A.length;
			if(A[mid] <= A[next] && A[mid] <= A[prev])
				return mid;
			else if(A[mid] <= A[right])
				right = mid-1;
			else if(A[mid] >= A[left])
				left = mid+1;
				
		}
		return -1;
	}
}
