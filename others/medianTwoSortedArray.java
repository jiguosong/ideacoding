package others;

import java.util.Arrays;

public class medianTwoSortedArray {
	
	//Find the median of the two sorted arrays
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) return 0;
		if (nums2 == null || nums2.length == 0) return 0;
		
		int total = nums1.length + nums2.length;
		if((total & 0x1) == 1) {
			return findKth(nums1, 0, nums2, 0, total/2+1);
		} else {
			double a = findKth(nums1, 0, nums2, 0, total/2);
			double b = findKth(nums1, 0, nums2, 0, total/2+1);
			return (a+b)/2;
		}
	}
	
	// we compare a[k/2-1] and b[k/2-1]. If a[k/2-1] < b[k/2-1], this means that a[0]....a[k/2-1] must be among the k smallest 
	// elements in the merged array in another word, a[k/2-1] can not be larger than kth largest number. So we can exclude it and try to find (k-k/2)th one
	
	// find kth element in general
	private double findKth(int[] a, int a_start, int[] b, int b_start, int k){
		if (k <= 0 || k > a.length+b.length) return 0;
		
		if (a_start >= a.length) return b[b_start+k-1];
		if (b_start >= b.length) return a[a_start+k-1];	
		
		if (k == 1) return Math.min(a[a_start], b[b_start]);
		
		int mid_a = a_start + k/2 - 1;
		int mid_b = b_start + k/2 - 1;
		
		int a_val = (mid_a < a.length) ? a[mid_a]: Integer.MAX_VALUE;
		int b_val = (mid_b < b.length) ? b[mid_b]: Integer.MAX_VALUE;
		
		if (a_val < b_val) {
			return findKth(a, mid_a+1, b, b_start , k - k/2);
		} else {
			return findKth(a, a_start, b, mid_b+1, k - k/2);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		medianTwoSortedArray test = new medianTwoSortedArray();
		//int[] nums1 = {1, 12, 15, 26, 51};
		//int[] nums2 = {2, 9, 17, 30, 45};
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};

		double ans = 0;
		ans = test.findMedianSortedArrays(nums1, nums2);
		System.out.println(ans);
		
		double ans2 = test.findKth(nums1, 0, nums2, 0, 6);
		System.out.println(ans2);

	}

}
