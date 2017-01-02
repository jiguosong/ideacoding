package dp.src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import dp.test.My_Dictionary;

public class wordbreak {
	
	public boolean wordBreak_bigdict(String s, Set<String> dict) {
		if(s == null || s.length() ==0) return false;
		if(dict == null || dict.size() == 0) return false;
		
		int n = s.length();
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
		
		for(int i = 0; i < s.length(); i++) {
			if(!dp[i]) continue;
			for(int j = i+1; j <= s.length(); j++) {				
				String tmp = s.substring(i, j);
				if(dict.contains(tmp)) dp[j] = true;
			}
		}
		
		return dp[s.length()];	
	}
	
	
	public boolean wordBreak_on_model(String s, Set<String> dict) {
		if(s == null || s.length() ==0) return false;
		if(dict == null || dict.size() == 0) return false;
		
		int n = s.length();
		
		boolean[] isbreakable = new boolean[n+1];
		isbreakable[0] = true;
		
		for(int i = 0; i <= n; i++) {
			if(isbreakable[i] == false) continue;
			for(String e:dict) {
				if(i+e.length() <= n && s.substring(i, i+e.length()).equals(e)) {
					isbreakable[i+e.length()] = true;
				}
			}
		}
		
		return isbreakable[n];
	}
	
	
	public static List<String> wordBreak_II_on_model(String s, Set<String> dict) {
		if(s == null || s.length() ==0) return null;
		if(dict == null || dict.size() == 0) return null;
		
		 List<String> res = new ArrayList<String>();
		 int n = s.length();
		 List<String>breakable_words [] = new ArrayList[n+1];
		 breakable_words[0] = new ArrayList<String>();
		 
		 for(int i = 0; i <= n; i++) {
			 if(breakable_words[i] == null) continue;
			 for(String e:dict) {
				 if(i+e.length() <= n && s.substring(i, i+e.length()).equals(e)) {
					 if(breakable_words[i+e.length()] == null) breakable_words[i+e.length()] = new ArrayList<String>();
					 breakable_words[i+e.length()].add(e);
				 }
			 }
		 }
		
		 if(breakable_words[n] == null) return res;  // not breakable, just return
		 List<String> tmp = new ArrayList<String>();
		 wordBreak_II_on_model_helper(breakable_words, n, tmp, res);
		
		 return res;
	}
	
	// check from back to front
	private static void wordBreak_II_on_model_helper(List<String>breakable_words [],int len, List<String> tmp, List<String> res) {
		if(len <= 0) {
			String str = tmp.get(tmp.size()-1);
			for(int i = tmp.size()-2; i >= 0; i--) str += " " + tmp.get(i);
			res.add(str);
			return;
		}
		
		for(String e: breakable_words[len]) {
			tmp.add(e);
			wordBreak_II_on_model_helper(breakable_words, len-e.length(), tmp, res);
			tmp.remove(tmp.size()-1);
		}		
	}
	
	public boolean wordBreak(String s, Set<String> dict) {
		if(s == null || s.length() ==0) return false;
		if(dict == null || dict.size() == 0) return false;
		
		int n = s.length();
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
		
		for(int i = 0; i < s.length(); i++) {
			if(!dp[i]) continue;
			for(String e:dict) {
				int len = e.length();
				int end = i+len;				
				if(end > s.length()) continue;
				
				if(dp[end]) continue;				
				if(s.substring(i, end).equals(e)) dp[end] = true;
			}
		}
		
		return dp[s.length()];		
	}

	public boolean wordBreak_naive(String s, Set<String> dict) {
		if(s == null || s.length() ==0) return false;
		if(dict == null || dict.size() == 0) return false;
		
		return wordBreak_naive_helper(s, dict, 0);
	}
	
	private boolean wordBreak_naive_helper(String s, Set<String> dict, int level) {
		if(level == s.length()) return true;
		
		for(String e:dict) {
			int len = e.length();
			int end = level + len;
			
			if(end > s.length()) continue;
			
			if(s.substring(level, end).equals(e)) {
				if(wordBreak_naive_helper(s, dict, end)) return true;
			}
		}
		
		return false;			
	}

	/**
	 * @param args
	 */
	public static void main (String[] args) throws FileNotFoundException, IOException {
		wordbreak test = new wordbreak();
		My_Dictionary md = new My_Dictionary();
		Set<String> dict  = md.getDictSet();
		
		Set<String> dict2 = new HashSet<String>();
		dict2.add("leet");
		dict2.add("code");		
		
		String s = "leetcode";		   
		if(test.wordBreak_naive(s, dict2)) System.out.println("can be broken");
		else System.out.println("can not be broken");

		if(test.wordBreak(s, dict2)) System.out.println("can be broken");
		else System.out.println("can not be broken");

		if(test.wordBreak_on_model(s, dict2)) System.out.println("can be broken");
		else System.out.println("can not be broken");

		if(test.wordBreak_bigdict(s, dict2)) System.out.println("can be broken");
		else System.out.println("can not be broken");
		
		String s2 = "catsanddog";
		Set<String> dict3 = new HashSet<String>();
		dict3.add("cat");
		dict3.add("cats");	
		dict3.add("and");
		dict3.add("sand");
		dict3.add("dog");
				
		List<String> res= test.wordBreak_II_on_model(s2,dict3);
		System.out.println(res);
	}

}
