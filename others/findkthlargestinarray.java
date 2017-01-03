package others;

import java.util.*;

public class findkthlargestinarray {
	
	// in an unsorted array
	public int findKthLargest(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k <= 0) return 0;
		
		Queue<Integer> pq = new PriorityQueue<Integer>();		
		
		for(int e:nums) {
			pq.add(e);
			// throw (n-k) smallest item, eventaully we will have k largest in the heap, and the top one is the Kth
			if(!pq.isEmpty() && pq.size() > k) pq.remove();
		}
		
		return pq.peek();
	}
	
	public int findKthLargest_selection(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k <= 0) return 0;
		
		return select(nums, nums.length-k+1, 0, nums.length-1);
	}
	
	private int select(int[] nums, int k, int start, int end) {
		int pivot = nums[end];
		int left = start;
		int right = end;
		
		while(true) {
			while(left < right && nums[left] < pivot) left++;
			while(left < right && nums[right] >= pivot) right--;
			if(left >= right) break;
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
		}
		
		int tmp = nums[left];
		nums[left] = nums[end];
		nums[end] = tmp;
		
		if(k == left + 1) return pivot;
		else if(k < left+1) return select(nums, k, start, left-1);
		else return select(nums, k, left+1, end);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findkthlargestinarray test = new findkthlargestinarray();
		int[] nums = {3,2,1,5,6,4};
		int k = 5;
		int ans = test.findKthLargest(nums, k);
		System.out.println(ans);
		
		ans = test.findKthLargest_selection(nums, k);
		System.out.println(ans);
	}

}
