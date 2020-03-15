package com.practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class IntervalExample {

	static class Interval
	{
		int start;
		int end;
		Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		
		
	}
	public static void main(String[] args) {
		/*
		 * Meeting room and interval examples solved using priorityQueue
		 */
		Interval[] intervals = new Interval[5];
		intervals[0] = new Interval(2,15);
		intervals[1] = new Interval(36,45);
		intervals[2] = new Interval(9,29);
		intervals[3] = new Interval(16,23);
		intervals[4] = new Interval(4,9);
		System.out.println("Min no of meeting rooms required is " + findMinNoOfMeetingRooms(intervals));
		
		Interval[] intervals1 = new Interval[5];
		intervals1[0] = new Interval(1,3);
		intervals1[1] = new Interval(2,6);
		intervals1[2] = new Interval(8,10);
		intervals1[3] = new Interval(15,18);
		intervals1[4] = new Interval(17,20);
		
		System.out.println("Merge Intervals : " + mergeIntervals(intervals1));
		
	}
	
	public static List<Interval> mergeIntervals(Interval[] intervals){
		Arrays.sort(intervals,(a,b) -> a.start - b.start);
		
		List<Interval> ans = new ArrayList<>();
		Interval t = intervals[0];
		for(int i =1;i<intervals.length;i++) {
			Interval c = intervals[i];
			if(t.end >= c.start) {
				t.end = Math.max(t.end, c.end);
			} else {
				ans.add(t);
				t = c;
			}
			
		}
		
		ans.add(t);
		
		return ans;
	}
	
	public static int findMinNoOfMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, (a,b) -> a.start - b.start);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(intervals[0].end);
		int count = 1;
		for(int i=1; i< intervals.length; i++) {
			if(intervals[i].start >= pq.peek()) {
				pq.poll();
			} else {
				count++;
			}
			pq.offer(intervals[i].end);
		}
		
		return count;
	}

}
