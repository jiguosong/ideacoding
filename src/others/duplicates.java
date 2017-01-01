package others;

import java.util.*;

public class duplicates {
	
	// just remove duplicates (sorted array)
	public int[] removeDuplicatesNaive(int[] A) {
		if(A == null || A.length < 2) return null;
	
		int slow = 0;
		int fast = 1;

		while(fast < A.length) {
			if (A[fast] != A[slow]) {
				slow++;
				A[slow] = A[fast];
			}
			fast++;
		}
		
		int[] B = Arrays.copyOf(A, slow+1);
		return B;		
	}
	
	// duplicates are allowed at most twice after delete
	public int[] removeDuplicates(int[] A) {
		if(A == null || A.length < 2) return null;
		
		int slow = 1;
		int fast = 2;
		
		while(fast < A.length) {
			if (A[fast] != A[slow] || A[fast] != A[slow-1]) {
				slow++;
				A[slow] = A[fast];
			}
			fast++;
		}
		
		int[] B = Arrays.copyOf(A, slow+1);
		return B;	
		
	}
	
	//  remove all instances of that value in place and return the new length
	public int[] removeElement(int[] A, int elem) {
		if(A == null || A.length < 2) return null;
		
		int slow = -1;
		int fast = 0;
		
		while(fast < A.length) {
			if (A[fast] != elem) {
				slow++;
				A[slow] = A[fast];
			}
			fast++;			
		}
		
		int[] B = Arrays.copyOf(A, slow+1);
		return B;
	}
	
	//  move all 0's to the end of it while maintaining the relative order of the non-zero elements
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length < 2) return;
		
		int slow = -1;
		int fast = 0;
		
		while(fast < nums.length) {
			if (nums[fast] != 0) {
				slow++;
				nums[slow] = nums[fast];
			}
			fast++;			
		}
		
		slow++;
		while(slow < nums.length) {
			nums[slow] = 0;
			slow++;
		}
	}
	
	//  if the array contains any duplicates
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0) return true;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int e : nums) {
			if (!set.add(e)) return false;
		}
		
		return true;
	}	
	
	// Given an array of integers and an integer k, return true if and only if there are two distinct indices i and j in the array 
	// such that nums[i] = nums[j] and the difference between i and j is at most k.
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || nums.length == 0) return true;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int pre_idx = map.get(nums[i]);
				if (i-pre_idx <= k) return true;
			}
			map.put(nums[i], i);
		}
		
		return false;		
	}
	
	// find out whether there are two distinct indices i and j in the array such that the difference between nums[i] 
	// and nums[j] is at most t and the difference between i and j is at most k
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || nums.length == 0) return false;
		
		TreeSet<Integer> treeset = new TreeSet<Integer>();	

		for(int i = 0; i < nums.length; i++) {
			Integer curr = nums[i];
			Integer left_most = curr - t;
			Integer right_most = curr + t + 1;			
			SortedSet<Integer> sortedSet = treeset.subSet(left_most, right_most);
			if (sortedSet.size() > 0) return true; 	
			
			treeset.add(nums[i]);
			
			if (i >= k) treeset.remove(nums[i-k]);
		}
		
		return false;
	}
	
	
/*	Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at 
	least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
	Note: the duplicated one could be repeated
*/	

	// Solution 1:  Binary search  O(nlogn)
	public int findDuplicate(int[] arr) {
		if(arr == null || arr.length == 0)  return 0;
		
		int left = 0;
		int right = arr.length-1;
		
		while(left < right){
			int mid = left + (right-left)/2;
			int cnt = 0;
			
			for(int e : arr) if(e < mid) cnt++;
			
			if(cnt > mid) right = mid;
			else left = mid+1;
		}
		
		return arr[left];	
	}
	
	// Solution 2:  every item "points" at another node, so this is like a graph. We can find a cycle if there are duplicated node
	// this is similar to the finding cycle in linked list. We can use fast ans slow
	public int findDuplicate_cycle(int[] arr) {
		if(arr == null || arr.length == 0)  return 0;
		
		int res = 0;
		int slow_idx = 0;
		int fast_idx = 0;
		
		do{
			slow_idx = arr[slow_idx]; 
			fast_idx = arr[arr[fast_idx]];
		} while(slow_idx != fast_idx);   // assume there is cycle, and this is where they meet
	
		while(res != slow_idx) {
			slow_idx = arr[slow_idx];
			res = arr[res];
		}
		
		return res;		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		duplicates test = new duplicates();
		int[] nums = {1,10,20,15,2,6,99,1};

		if (test.containsDuplicate(nums)) System.out.println("NO duplicated");
		else System.out.println("Yes duplicated");

		if (test.containsNearbyDuplicate(nums,5)) System.out.println("Yes exist <= k");
		else System.out.println("No exist");

		if (test.containsNearbyAlmostDuplicate(nums, 1, 4)) System.out.println("Yes exist i-j<= k and nums[i]-nums[j]<=t");
		else System.out.println("No exist");
		
		int[] A = {1,2,2,2,2,2,3, 3, 3,5,6, 6};
		int[] B = test.removeDuplicatesNaive(A);
		System.out.println("after remove, B is " + Arrays.toString(B));

		int[] A2 = {1,2,2,2,2,2,3, 3, 3,5,6, 6};
		int[] C = test.removeDuplicates(A2);
		System.out.println("after remove, C is " + Arrays.toString(C));

		int[] A3 = {1,2,5,1,65,8,2,9,2,4,6,1,0,12};
		int[] D = test.removeElement(A3, 1);
		System.out.println("after remove, D is " + Arrays.toString(D));

		int[] A4 = {0,2,0,1,65,0,2,9,0,4,6,1,0,12};
		test.moveZeroes(A4);
		System.out.println("after remove, E is " + Arrays.toString(A4));

		int[] A5 = {1,2,3,4,4};
		int finddupli = test.findDuplicate(A5);
		System.out.println("found duplicated one: " + finddupli);
		finddupli = test.findDuplicate_cycle(A5);
		System.out.println("found duplicated one: " + finddupli);
	
	}

}
