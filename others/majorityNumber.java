package others;

import java.util.*;
public class majorityNumber {
	
	//  The majority element is the element that appears more than ⌊ n/2 ⌋ times
	public int majorityElement(int[] num) {
		if(num == null || num.length == 0) return -1;
		
		int res = 0;
		int level = 0;
		for(int i = 0; i < num.length; i++) {
			if(num[i] == res) {
				level++;
			} else if(level == 0) {
				res = num[i];
				level = 1;
			} else level--;
		}	
		
		return res;
	}
	
	// find all elements that appear more than ⌊ n/3 ⌋ times. Hint: there are at most 2 majority > n/3
	public List<Integer> majorityElement3(int[] nums) {
		if(nums == null || nums.length == 0) return null;
		List<Integer> res = new ArrayList<Integer>();
		
		int level1 = 0; int level2 = 0;
		int m1 = 0; int m2 = 0;

		for(int e:nums) {
			if(m1 == e) {
				level1++;
			} else if(m2 == e) {
				level2++;
			} else if(level1 == 0) {
				m1 = e;
				level1 = 1;
			} else if(level2 == 0) {
				m2 = e;
				level2 = 1;
			} else {
				level1--;
				level2--;
			}
		}
		
		level1 = 0;
		level2 = 0;
		for(int e:nums) {
			if(e == m1) level1++;
			else if(e == m2) level2++;
		}
		
		if(level1 > nums.length/3) res.add(m1);
		if(level2 > nums.length/3) res.add(m2);		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		majorityNumber test = new majorityNumber();
		int[] num = {1,2,3,4,2,1,1,2,2};
		int ans = test.majorityElement(num);
		System.out.println(ans);
		
		int[] nums = {1,2,2,4,2,1,1,1,2};
		List<Integer> ret = test.majorityElement3(nums);
		System.out.println(ret);
	}

}
