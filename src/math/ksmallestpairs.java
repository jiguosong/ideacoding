package math;

import java.util.*;

public class ksmallestpairs {
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		if(nums1 == null || nums1.length == 0) return null;
		if(nums2 == null || nums2.length == 0) return null;
		if(k <= 0) return null;
		
		List<int[]> res = new ArrayList<int[]>();
		int n = nums1.length;    // this is like the primes array
		int m = nums2.length;    // this is like the res in superugly 
		k = Math.min(k, m*n);   // item can be repeatedly used
		
		int[] right_idxes = new int[n];   // this is like the indx tracking in superugly
		
		while(res.size() < k) {
			int min = Integer.MAX_VALUE;
			int p = 0;
			for(int i = 0; i < n; i++) {
				if(i >= n) continue;
				int tt = nums1[i]+nums2[right_idxes[i]];
				if(min > tt) {
					min = tt;
					p = i;
				}				
			}			
			int[] tmp = {nums1[p], nums2[right_idxes[p]]};
			res.add(tmp);
			
			right_idxes[p]++;
		}
		
		return res;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ksmallestpairs test = new ksmallestpairs();
		
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		int k = 3;
		List<int[]> ans = test.kSmallestPairs(nums1, nums2, k);
		
		Iterator<int[]> it = ans.iterator();
		while(it.hasNext()) {
			int[] tmp = it.next();
			System.out.println(Arrays.toString(tmp));
		}
	}

}
