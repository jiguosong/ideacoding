package others;

import java.util.*;

/* Rotate an array of n elements to the right by k steps */
// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]

public class rotate_array {
	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) return;
		int n = nums.length;
		
		if (k > n) k = k%n;		
		reverse(nums, 0, n-k-1);	
		reverse(nums, n-k, n-1);
		reverse(nums, 0, n-1);
	}
	
	public static void reverse(int[] a, int l, int r){
		int tmp;
		while (l < r) {
			tmp  = a[l];
			a[l] = a[r];
			a[r]  = tmp;
			l++;
			r--;
		}
	}
	
	public static void main(String[] args){
		System.out.println("rotate array test");
		
		int[] input = {1,2,3,4,5,6,7};
		int k = 3;
		
		for (int i = 0; i < input.length; i++) System.out.print(input[i]);
		
		System.out.println();
		
		rotate(input, k);
		
		for (int i = 0; i < input.length; i++) System.out.print(input[i]);
		
	}
	
}