package dp.src;

import java.util.*;

// Given a string, find the length of the longest substring T that contains at most k distinct characters
// For example, Given s = “eceba” and k = 2, T is "ece" which its length is 3.
public class longestatmostKdistinct {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0) return 0;
		if (s.length() < k) return s.length();
		
		int max = 0;
		int left = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();  // map char to its counter
		
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (map.containsKey(c)) {
				int count = map.get(c);
				map.put(c, count+1);
			} else {
				map.put(c, 1);
			}
			
			if (map.size() > k) {
				max = Math.max(max, i - left);
				while(map.size() > k) {
					Character tmp_c = s.charAt(left);
					int tmp_n = map.get(tmp_c);
					if(tmp_n > 1) map.put(tmp_c, tmp_n-1);
					else map.remove(tmp_c);
					left++;
				}
			}
		}
		
		max = Math.max(max, s.length() - left);
		
		return max;	
	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) return 0;
		if (s.length() < 3) return s.length();
		
		int max = 0;
		int left = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (map.containsKey(c)) {
				int count = map.get(c);
				map.put(c, count+1);
			} else {
				map.put(c, 1);
			}
			
			if (map.size() > 2) {
				max = Math.max(max, i - left);
				while(map.size() > 2) {
					Character tmp_c = s.charAt(left);
					int tmp_n = map.get(tmp_c);
					if(tmp_n > 1) map.put(tmp_c, tmp_n-1);
					else map.remove(tmp_c);
					left++;
				}
			}
		}
		
		max = Math.max(max, s.length() - left);
		
		return max;	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		longestatmostKdistinct test = new longestatmostKdistinct();
		String s = "abcadcacacaca";
		int ans = test.lengthOfLongestSubstringTwoDistinct(s);
		System.out.println(ans);
		
		ans = test.lengthOfLongestSubstringKDistinct(s,11);
		System.out.println(ans);

	}

}
