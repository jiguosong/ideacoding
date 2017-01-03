package others;

import java.util.*;

public class shortestWordDistance {
	
	// simple iterate (word1 != word2)
	public int shortestDistance_simple(String[] words, String word1, String word2) {
		if(words == null || word1 == null || word2 == null) return 0;
		if(words.length == 0 || word1.length() == 0 || word2.length() == 0) return 0;
		
		int p1 = -1;
		int p2 = -1;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) p1 = i;
			if(words[i].equals(word2)) p2 = i;
			if(p1 != -1 && -1 != p2) min = Math.min(min, Math.abs(p1-p2));			
		}
		
		return min;		
	}	

	// simple iterate (word1 can be same as word2)
	public int shortestDistance_simple_same(String[] words, String word1, String word2) {
		if(words == null || word1 == null || word2 == null) return 0;
		if(words.length == 0 || word1.length() == 0 || word2.length() == 0) return 0;
		
		int p1 = -1;
		int p2 = -1;
		int t = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < words.length; i++) {
			t = p1;
			if(words[i].equals(word1)) p1 = i;
			if(words[i].equals(word2)) p2 = i;
			if(p1 != -1 && -1 != p2) {
				if(word1.equals(word2) && t != -1 && t != p1) min = Math.min(min, Math.abs(p1-t));
				else if(p1 != p2) min = Math.min(min, Math.abs(p1-p2));
			}
		}		
		return min;		
	}	

	// use hashmap
	public int shortestDistance(String[] words, String word1, String word2) {
		if(words == null || word1 == null || word2 == null) return 0;
		if(words.length == 0 || word1.length() == 0 || word2.length() == 0) return 0;

		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		
		for(int i = 0; i < words.length; i++) {
			String key = words[i];
			if(map.containsKey(key)) map.get(key).add(i);
			else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(key, list);
			}
		}
		
		
		List<Integer> a = map.get(word1);
		List<Integer> b = map.get(word2);
		
		if(a == null || b == null) return 0;
		
		int min = Integer.MAX_VALUE;
		
	/*	// this can be optimized
		for(int k:a) {
			for(int p:b) {
				min = Math.min(min, Math.abs(k-p));
			}
		}
		*/
		
		int idx1 = 0;
		int idx2 = 0;
		while(idx1 < a.size() && idx2 < b.size()) {
			min = Math.min(min, Math.abs(a.get(idx1)-b.get(idx2)));
			if (a.get(idx1)<b.get(idx2)) idx1++;
			else idx2++;
		}
		
		return min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		shortestWordDistance test = new shortestWordDistance();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding";
		String word2 = "practice";
		int ans = test.shortestDistance_simple(words, word1, word2);
		System.out.println(ans);
		ans = test.shortestDistance_simple_same(words, word1, word2);
		System.out.println(ans);
		ans = test.shortestDistance(words, word1, word2);
		System.out.println(ans);

	}

}
