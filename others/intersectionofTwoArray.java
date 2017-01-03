package others;

import java.util.*;

public class intersectionofTwoArray {
	
	// find all intersects
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null) return null;
		
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int e:nums1) {
			if(map.containsKey(e)) map.put(e, map.get(e)+1);
			else map.put(e, 1);
		}
		
		for(int e:nums2) {
			if(map.containsKey(e)) {
				int cnt = map.get(e);
				if(cnt >= 1) {
					map.put(e, map.get(e)-1);
					list.add(e);
					if(cnt == 1) map.remove(e);
				}
			}
		}		
		
		
		int[] res = new int[list.size()];
		int i = 0;
		for(int e:list) {
			res[i] = e;
			i++;
		}
		
		return res;
	}
	
	
	// Given two arrays, write a function to compute their intersection
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null) return null;
		
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		
		for(int e:nums1) set1.add(e);
		
		for(int e:nums2) {
			if(set1.contains(e)) set2.add(e);
		}
		
		int[] res = new int[set2.size()];
		int i = 0;
		for(int e:set2) {
			res[i] = e;
			i++;
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		intersectionofTwoArray test = new intersectionofTwoArray();
		
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2, 1};
		
		int[] ans = test.intersection(nums1, nums2);
		for(int e:ans) System.out.print(e+" ");

		System.out.println();
		ans = test.intersect(nums1, nums2);
		for(int e:ans) System.out.print(e+" ");

	}

}
