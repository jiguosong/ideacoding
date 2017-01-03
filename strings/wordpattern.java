package strings;

import java.util.*;

public class wordpattern {
	
	public boolean wordPatternMatch(String pattern, String str) {
		if(pattern == null || pattern.length() == 0) return false;
		if(str == null || str.length() == 0) return false;

		Map<Character, String> map = new HashMap<Character, String>();
		
		return wordPatternMatch_helper(pattern, str, 0, 0, map);
	}
	
	private boolean wordPatternMatch_helper(String pattern, String str, int p_level, 
												int s_level, Map<Character, String> map) {
		if(p_level == pattern.length() && s_level == str.length()) return true;
		if(p_level >= pattern.length() || s_level >= str.length()) return false;
		
		char c = pattern.charAt(p_level);
		
		for(int i = s_level; i < str.length(); i++) {
			String s = str.substring(s_level, i+1);
			if(map.containsKey(c) && map.get(c).equals(s)) {
				if(wordPatternMatch_helper(pattern, str, p_level+1, i+1, map)) return true;
			} else if (!map.containsKey(c) && !map.containsValue(s)) {
				map.put(c, s);
				if(wordPatternMatch_helper(pattern, str, p_level+1, i+1, map)) return true;
				map.remove(c);
			}			
		}
		
		return false;
	}

	public boolean wordPattern(String pattern, String str) {
		if(pattern == null || pattern.length() == 0) return false;
		if(str == null || str.length() == 0) return false;
		
		String[] bstrs = str.split(" ");
		if(pattern.length() != bstrs.length) return false;
		
		Map<Character, String> map = new HashMap<Character, String>();
		for(int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if(map.containsKey(c)) {
				if(!map.get(c).equals(bstrs[i])) return false;
			} else {
				if(map.containsValue(bstrs[i])) return false;
				map.put(c, bstrs[i]);
			}
		}
		
		return true;		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		wordpattern test = new wordpattern();
		String pattern = "abba";
		String str = "dog cat cat dog";
		if(test.wordPattern(pattern, str)) System.out.println("True");
		else System.out.println("False");
		
		String pattern2 = "abab";
		String str2 = "redblueredblue";
		if(test.wordPatternMatch(pattern2, str2)) System.out.println("Match True");
		else System.out.println("Match False");
		
	}

}
