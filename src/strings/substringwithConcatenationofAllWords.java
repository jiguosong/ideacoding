package strings;

// not finished yet

import java.util.*;

public class substringwithConcatenationofAllWords {
	
	// Find all starting indices of substring(s) in s that is a concatenation of each word 
	// in words exactly once and without any intervening characters.
	// For example, given: s="barfoothefoobarman" & words=["foo", "bar"], return [0,9]
	
	public List<Integer> findSubstring(String s, String[] words) {
		if(s == null || s.length() == 0 || words == null || words.length ==0) return null;
		List<Integer> res = new ArrayList<Integer>();
		
		int step = words[0].length();
		
		Map<String, Integer> words_map = new HashMap<String, Integer>();
		for(String e : words) {
			if(words_map.containsKey(e)) words_map.put(e, words_map.get(e)+1);
			else words_map.put(e, 1);
		}
		
		
		for(int i = 0; i < step; i++) {
			
			Map<String, Integer> curr_map = new HashMap<String, Integer>();
			int start = i;
			int count = 0;
			for(int j = i; j < s.length()-step; j = j+step) {
				String str = s.substring(j, j+step);
				if(words_map.containsKey(str)) {
					if(curr_map.containsKey(str)) {
						if (curr_map.get(str) < words_map.get(str)) count++;
						curr_map.put(str, curr_map.get(str)+1);						
					} else {
						curr_map.put(str, 1);
						count++;
					}
				
					if(count == words.length) {
						String tmp_s = s.substring(start, start+step);
						while(!curr_map.containsKey(tmp_s) || curr_map.get(tmp_s) > words_map.get(tmp_s)) {
							if(curr_map.containsKey(tmp_s) && curr_map.get(tmp_s) > words_map.get(tmp_s)) {
								curr_map.put(tmp_s, curr_map.get(tmp_s)-1);
							}
							start += step;
							tmp_s = s.substring(start, start+step);
						}
						
						res.add(start);			
					}	
					
				} else {
					start = j + step;
					count = 0;
					curr_map.clear();
				}
			}
		}
		
		return res;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		substringwithConcatenationofAllWords test = new substringwithConcatenationofAllWords();
		String s = "barfoofoothefoobarfooman";
		String[] words = {"foo","bar", "foo"};
		List<Integer> ans = test.findSubstring(s, words);
		System.out.println(ans);

	}

}
