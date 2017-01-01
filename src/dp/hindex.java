package dp;

import java.util.*;

public class hindex {
	
	// here are 2 approaches: y = x, and y = -x+N;
	// the idea is similar, just find the boundary point that either x >= y, or -x+N >= y (see the plot)
	
	/*
	    | *    /
		|  *  / 
		|    /
		|   /  * 
		|  / 
		| /         *
		|/_______________     or      
		
		
		
		| \        *
		|  \
		|   \  *
		|  	 \
		|   * \
		|  *   \
		|_______\________   
	*/	
	public int hIndex(int[] citations) {
		if(citations == null || citations.length ==0) return 0;
		
		Integer[] sorted_array = new Integer[citations.length];
		int j = 0;
		for (int value : citations) {
			sorted_array[j++] = Integer.valueOf(value);
		}
		
		Arrays.sort(sorted_array, Collections.reverseOrder());
		
		for (int value : sorted_array) {
			System.out.print(value + " ");
		}
		for(int i = 0; i < sorted_array.length; i++) {
			if(i >= sorted_array[i]) return i;
		}
		
		System.out.println();
		Arrays.sort(citations);
		for (int value : citations) {
			System.out.print(value + " ");
		}
		
		for(int i = 0; i < citations.length; i++) {
			if(citations.length-i <= citations[i]) return citations.length-i;
		}
		
		
		return 0;
		
	}
	
	// sorted in ascending order. See the plot B
	public int hIndex_sorted(int[] citations) {
		assert (citations != null); 
		assert (citations.length != 0);
		
		int left = 0;
		int right = citations.length-1;
		
		int n = citations.length;
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(citations[mid] ==n -mid) return n-mid;
			else if(citations[mid] > n-mid) right = mid-1;
			else left = mid+1; 
		}
		
		return n-left;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		hindex test = new hindex();
		
		int[] citations = {3,0,6,1,5};		
		int ans = test.hIndex(citations);
		System.out.println();
		System.out.println(ans);

		int[] citations2 = {1,2,3,4,5,6,7};		
		ans = test.hIndex_sorted(citations2);
		System.out.println();
		System.out.println(ans);

	}

}
