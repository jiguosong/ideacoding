package strings;

import java.util.*;

/* Given two strings s and t, determine if they are isomorphic */
// Two strings are isomorphic if the characters in s can be replaced to get t

public class isIsomorphicStr {
	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) return true;
		if (s == null && t != null) return false;
		if (s != null && t == null) return false;
		
		if (s.length() != t.length()) return false;
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		
		for(int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if (!map.containsKey(c1)) {
				map.put(c1, c2);
			} else {
				if (!map.get(c1).equals(c2)) return false;
			}
		}
		
		return true;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		isIsomorphicStr test = new isIsomorphicStr();
		String s = "foo";
		String t = "bar";
		if (test.isIsomorphic(s, t)) System.out.println("True");
		else System.out.println("False");

	}

}
