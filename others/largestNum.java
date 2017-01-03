package others;

import java.util.*;

class compareNumsStr implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		return (b+a).compareTo(a+b);
	}
}

public class largestNum {
	public String largestNumber(int[] nums) {
		if(nums == null || nums.length == 0) return null;
		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(strs, new compareNumsStr());
		StringBuilder sb = new StringBuilder();
		for(String s : strs) {
			sb.append(s);
		}
		
		while(sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
		
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		largestNum test = new largestNum();
		int[] nums = {3, 30, 34, 5, 9};
		String ans = test.largestNumber(nums);
		System.out.println(ans);

	}

}
