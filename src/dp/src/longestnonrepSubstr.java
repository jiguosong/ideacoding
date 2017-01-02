package dp.src;

import java.util.*;

// the solution has some dp style

public class longestnonrepSubstr {
	public int findLongNonRepStr(String s){
		if (s == null || s.length() == 0) return 0;
		int ret = 0;
		
		int[] map = new int[256];
		Arrays.fill(map, 0);
		
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map[s.charAt(i)] == 0 || map[s.charAt(i)] < left)   // first time see or already contains a rep str, need use updated start
				ret = Math.max(ret, i - left + 1);
			else
				left = map[s.charAt(i)];   // the start position of non-rep str
			
			map[s.charAt(i)] = i+1;
		}
		
		return ret;
	}
	
	// use set and remove when encounter the same char
	public int findLongNonRepStr_use_set(String s){
		if (s == null || s.length() == 0) return 0;
		int res = 0;
		int left = 0;

		Set<Character> set = new HashSet<Character>();
		
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(!set.contains(c)) {
				set.add(c);
				res = Math.max(res, set.size());
			} else {
				while(set.contains(c)) {
					set.remove(s.charAt(left));
					left++;
				}
			}
		}
		
		return res;
	}
	
	// same as above, just use map here
	public int findLongNonRepStr_use_map(String s){
		if (s == null || s.length() == 0) return 0;
		int max = 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, i);
				max = Math.max(max, map.size());	
			} else {
				while(map.containsKey(c)) {
					map.remove(s.charAt(left));
					left++;
				}
			}
		}
		
		return max;
	}		
	
	
	public static void main(String[] args) {
		System.out.println("Java:LongestNonrepSubstr");
		longestnonrepSubstr test = new longestnonrepSubstr();
		String s = new String("abcabcbb");
		System.out.println(s);
		
		int result = test.findLongNonRepStr(s);
		System.out.println(result);
		result = test.findLongNonRepStr_use_map(s);
		System.out.println(result);
		result = test.findLongNonRepStr_use_set(s);
		System.out.println(result);
	}
}
