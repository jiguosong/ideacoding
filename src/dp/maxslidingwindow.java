package dp;

import java.util.*;

	//	Moving Average from Data Stream
	class MovingAverage {
		Deque<Integer> queue = null;
		int sum = 0;
		int size = 0;
		int avg = 0;
		
		MovingAverage(int size) {
			this.size = size;
			queue = new ArrayDeque<Integer>();
		}
		
		public int next(int val){
			queue.offer(val);
			sum += val;
			
			if(queue.size() <= 3 && queue.size() > 0) {
				avg = sum/queue.size();
			} else {
				int tmp = queue.peek();
				sum -= tmp;
				avg = sum/size;
				queue.poll();				
			}			
			return avg;
		}
	}
	
public class maxslidingwindow {
/*	
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
*/	
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0) return null;
		
		int[] res = new int[nums.length+1-k];
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for(int i = 0; i< nums.length; i++) {
			if(!deque.isEmpty() && deque.peekFirst() == i-k) deque.poll();
			while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
			
			deque.add(i);
			if(i+1-k >= 0) res[i+1-k] = nums[deque.peekFirst()];	
		}
		
		return res;		
	}
	
	public int[] maxSlidingWindow_test(int[] nums, int k) {
		if(nums == null || nums.length == 0) return null;
		
		Deque<Integer> queue = new ArrayDeque<Integer>();		  // track the index
		int n = nums.length;
		int[] res = new int[n+1-k];
		
		for(int i = 0; i < n; i++) {
			if(!queue.isEmpty() && i-queue.peekFirst() == k) queue.poll();
			while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) queue.removeLast();
			
			queue.add(i);	
			if(i+1-k >= 0) res[i+1-k] = nums[queue.peekFirst()]; 
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		maxslidingwindow test = new maxslidingwindow();
		
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;		
		int[] ans = test.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(ans));
	
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
	}
}
