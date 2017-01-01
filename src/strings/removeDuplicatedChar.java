package strings;

import java.util.*;

public class removeDuplicatedChar {
	
	public String removeDupChars(String s) {
		if (s == null || s.length() == 0) return null;
		
		Map<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char tmp =  s.charAt(i);
			if (!map.containsKey(tmp)) {
				map.put(tmp, i);
				sb.append(tmp);
			}
		}
		
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		removeDuplicatedChar test = new removeDuplicatedChar();
		String ans = test.removeDupChars("bacbabcbabcbabcabcbabcabcbabcbabcbacba");
		System.out.println(ans);

	}

}
