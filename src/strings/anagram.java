package strings;

import java.util.*;

public class anagram {
	
	public boolean isAnagram(String s, String t) {
		if(s == null || s.length() == 0) return false;
		if(t == null || t.length() == 0) return false;
		if(s.length() != t.length()) return false;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) map.put(c, map.get(c)+1);
			else map.put(c, 1);
		}
		
		for(int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if(map.containsKey(c)) {
				if(map.get(c) == 1) map.remove(c);
				else map.put(c, map.get(c)-1);
			} else return false;
		}
		
		
		return map.size() == 0;		
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		if(strs == null || strs.length == 0) return null;
		List<List<String>> res = new ArrayList<List<String>>();
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String str : strs) {
			char[] chars = new char[26];
			for(int i = 0; i < str.length(); i++) {
				if(Character.isUpperCase(str.charAt(i))) continue;
				chars[str.charAt(i)-'a']++;	
			}			
			
			String converted_k = new String(chars);
			
			if(map.containsKey(converted_k)) {
				map.get(converted_k).add(str);
			} else {
				List<String> tmp = new ArrayList<String>();
				tmp.add(str);
				map.put(converted_k, tmp);
			}			
		}
		
		
		res.addAll(map.values()); 
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		anagram test = new anagram();
		String[] strs = {"Torchwood","doctorwho"};
		List<List<String>> ans = test.groupAnagrams(strs);	
		Iterator<List<String>> it = ans.iterator();
		while(it.hasNext()) {
			List<String> tmp = it.next();
			System.out.println(tmp);
		}
		System.out.println();
		
		String s = "anagram";
		String t = "nagaram";
		if(test.isAnagram(s, t)) System.out.println("They are anagram");
		else System.out.println("They are not anagram");
	}

}
