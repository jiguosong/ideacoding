package others;

import java.util.Arrays;

public class firstmissingnumber {
	
	// Given an unsorted integer array, find the first missing positive integer.
	// Idea: 1) we can put 1 to A[0], 2 to A[1], ...... i+1 to A[i], or A[i] -> A[A[i]-1]
	//       2) so if A[i] > 0 && A[i] <= n and A[i] != A[A[i]-1] and A[i]-1 != i we swap them
	//       3) in the end, we scan from 1 to n to see which one does not satisfy A[i]-1 == i
	
	public int firstMissingPositive(int[] A) {    // every swap will make sure one A[i] will go to ith position. so O(n)
		if(A == null || A.length ==0) return 0;
		
		int i = 0;
		while(i < A.length) {
			if(A[i] > 0 && A[i] <= A.length && A[i] != A[A[i]-1] && A[i]-1 != i) {
				int tmp = A[i];
				A[i] = A[A[i]-1];
				A[tmp-1] = tmp; 
			} else i++;
		}
		
		for(int j = 0; j < A.length; j++) {
			if(A[j] != j+1) return j+1;
		}
		
		return A.length+1;		
	}
	
	public int missingNumber_xor(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		int res = 0;
	
		for(int i = 0; i < nums.length; i++) {
			res ^= nums[i]^(i+1);
		}
		
		return res;
		
	}
	
	public int missingNumber(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		Arrays.sort(nums);
		
		int left = 0;
		int right = nums.length;
		
		while(left < right) {
			int mid = left + (right-left)/2;			
			if(mid < nums[mid]) right = mid;
			else left = mid+1;			
		}
		
		return right;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstmissingnumber test = new firstmissingnumber();
		int[] nums = {0,1,2,5,4};
		int ans = test.missingNumber(nums);
		System.out.println(ans);
		ans = test.missingNumber_xor(nums);
		System.out.println(ans);

		int[] nums2 = {2,4,3,-5,-90,6,9,8,-2,7,-1,1};
		ans = test.firstMissingPositive(nums2);
		System.out.println(ans);

	}
}
