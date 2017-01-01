package strings;

import java.util.*;

public class firstNonrepeat {
	
	public char findFirstNonRepeatChar(String s) {
		if (s == null || s.length() == 0) return ' ';
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			} else {
				int count = map.get(s.charAt(i));
				map.put(s.charAt(i), count + 1);
			}
		}
		
		for (int i = 0; i < s.length(); i++) {
			int count = map.get(s.charAt(i));
			if (count == 1) return s.charAt(i);
		}
		
		return ' ';
	}
	
	class charwrapper{
		int times;
		int first_pos;
		
		charwrapper(int times, int first_pos) {
			this.times = times;
			this.first_pos = first_pos;
		}
	}
	
	public char findFirstNonRepeatChar_onescan(String s) {
		if (s == null || s.length() == 0) return ' ';
		Map<Character, charwrapper> map = new HashMap<Character, charwrapper>();
		
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), new charwrapper(1, i));
			} else {
				charwrapper cw = map.get(s.charAt(i));
				cw.times = cw.times+1;
			}
		}
		
		int min_pos = Integer.MAX_VALUE;
		for(Map.Entry<Character, charwrapper> e : map.entrySet()) {
			if (e.getValue().times == 1 && e.getValue().first_pos < min_pos) {
				min_pos = e.getValue().first_pos;
			}
		}
		
		
		return s.charAt(min_pos);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstNonrepeat test = new firstNonrepeat();
		String s = "GeeksforGeeks";
		char ans = test.findFirstNonRepeatChar_onescan(s);
		System.out.println(ans);

	}

}
