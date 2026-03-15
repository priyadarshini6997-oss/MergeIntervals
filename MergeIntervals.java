package com.in;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MergeIntervals {
	public int[][] merge(int[][] intervals){
	if(intervals.length<=1) {
		return intervals;
	}
	Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
	List<int[]> result = new ArrayList<>();
	int[] current = intervals[0];
	result.add(current);
	for(int i=1;i<intervals.length;i++) {
		int[] next = intervals[i];
		if(current[1]>=next[0]) {
			current[1]=Math.max(current[1],next[1]);
		}else {
			current = next;
			result.add(current);
		}
	}
	return result.toArray(new int[result.size()][]);
}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of intervals: ");
		int n = sc.nextInt();
		int[][] intervals = new int[n][2];
		System.out.println("Enter the intervals(start end): ");
		for(int i=0;i<n;i++) {
			intervals[i][0] = sc.nextInt();
			intervals[i][1] = sc.nextInt();
		}
		MergeIntervals obj = new MergeIntervals();
		
		int[][] result = obj.merge(intervals);
		
		System.out.println("The merged intervals: ");
		
		for(int[] interval : result) {
			System.out.println(interval[0]+" "+interval[1]);
		}
		sc.close();
		
	}
		
}
	


