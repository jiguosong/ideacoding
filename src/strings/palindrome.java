package strings;

import java.util.*;

public class palindrome {	
	////////////////////////////////////////
	/// if is a valid palindrome 
	////////////////////////////////////////
	public boolean isValidPalindromeStr(String s){
		if (s == null) return false;
		if (s.length() == 0) return true;
		
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		//System.out.println(s);
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
		}
		
		return true;		
	}
	
	////////////////////////////////////////
	/// shortest palindrome 
	////////////////////////////////////////
	
	public String shortestPalindrome_1(String s) {
		if(s == null || s.length() == 0) return null;
		
		int left = 0;
		int right = s.length()-1;
		
		while(right >= 0) {
			if(s.charAt(left) == s.charAt(right)) left++;
			right--;
		}
		
		if(left == s.length()) return s;   // this means every char in s has satisfied "s.charAt(left) == s.charAt(right)", so left++
		
		String suffix = s.substring(left);       // everything after left is not palindrome, let's call it T
		StringBuilder sb = new StringBuilder(suffix);
		String prefix = sb.reverse().toString();          // make a mirror of T here
		String mid = shortestPalindrome_1(s.substring(0, left));    // now process whatever is left, e.g., can contains some holes or skipped chars. Whatever it is, it is not a complete palindrome. So we can recursively deal with it
		
		return prefix+mid+suffix;		
	}
	
	// idea is simple, scan from the center which is potentially the longest palindrome, then next (by shifting left)
	public String shortestPalindrome_2(String s) {
		if(s == null || s.length() == 0) return null;
		
		int n = s.length();
		int mid = n/2;
		
		String res = null;
		for(int i = mid; i >= 1; i--) {
			if(s.charAt(i) == s.charAt(i-1)) {
				res = shortestPalindrome_helper(s, i-1, i);
				if(res != null) return res;
			} else {
				res = shortestPalindrome_helper(s, i-1, i-1);
				if(res != null) return res;
			} 
		}
		
		return res;
	}
	
	private String shortestPalindrome_helper(String s, int l, int r) {
		int i = 1;
		
		while(i <= l) {
			if(s.charAt(l-i) != s.charAt(r+i)) break;
			i++;
		}
		
		if(i <= l) return null;  // s is not palindrome
		
		StringBuilder sb = new StringBuilder(s.substring(r+i));
		sb.reverse();
		return sb.append(s).toString();
	}
	
	////////////////////////////////////////
	/// longest palindrome substring
	////////////////////////////////////////
	public String longestPalindrome_dp_on_model(String s) {
		if (s == null || s.length() == 0) return null;
		
		int[] res = new int[2];
		int max = 0;
		int n = s.length();
		boolean[][] isvalidPalindrome = new boolean[n+1][n+1];
		
		isvalidPalindrome[0][0] = true;
		for(int i = 1; i <= n; i++) {
			char c1 = s.charAt(i-1);
			for(int j = 1; j < n; j++) {
				char c2 = s.charAt(j-1);
				if((c1 == c2) && (isvalidPalindrome[i+1][j-1] || j-i<2)) {
					isvalidPalindrome[i][j] = true;
					if(j-i+1 > max) {
						max = j-i+1;
						res[0] = i;
						res[1] = j;
					}
				}				
			}
		}
		
		return s.substring(res[0], res[1]);
	}	
	
	
	
	public String longestPalindrome_dp(String s) {
		if (s == null || s.length() == 0) return null;
		
		int n = s.length();
		
		boolean[][] isPali = new boolean[n][n];
		isPali[0][0] = true;
		
		int left = 0; 
		int right = 0;
		int len = 0;
		for(int j = 1; j < n; j++) {
			isPali[j][j] = true;
			for(int i = 0; i < j; i++) {
				isPali[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i < 2 || isPali[i+1][j-1]) ;
				if (isPali[i][j] && len < j-i+1) {
					len = j-i+1;
					left = i;
					right = j;
				}
			}
		}
		
		return s.substring(left, right+1);
	}	
	
	public String longestPalindrome_2(String s) {
		if (s == null || s.length() == 0) return null;
		if(s.length() == 1) return s;
		
		int n = s.length();
		String max = s.substring(0,1);
		
		for(int i = 0; i < n; i++) {
			String tmp1 = longestPalindrome_helper(s, i, i);
			if(tmp1.length() > max.length()) max = tmp1;
			String tmp2 = longestPalindrome_helper(s, i, i+1);
			if(tmp2.length() > max.length()) max = tmp2;
		}

		return max;
	}
	
	private String longestPalindrome_helper(String s, int l, int r) {
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		
		return s.substring(l+1,r);		
	}
	
	// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
	public int longestPalindrome_can_be_built(String s) {
		if(s == null || s.length() == 0) return 0;
		
		Set<Character> set = new HashSet<Character>();  // track characters that appear odd times
		
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(set.contains(c)) set.remove(c);
			else set.add(c);
		}
		
		return s.length() - Math.max(0, set.size()-1);
		
	}
	
	////////////////////////////////////////
	/// palindrome pairs 
	////////////////////////////////////////
	public List<List<Integer>> palindromePairs(String[] words) {
		if(words == null || words.length == 0) return null;
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
			
		for(int i = 0; i < words.length; i++) map.put(words[i],i);
		
		for(int i = 0; i < words.length; i++) {
			String str = words[i];
			
			//case 0: str is palindrome itself
			if(isValidPalindromeStr(str) && map.containsKey("")) {
				if(map.containsKey("") && map.get("") != i) {
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(i);
					tmp.add(map.get(""));
					res.add(tmp);
					
					tmp = new ArrayList<Integer>();
					tmp.add(map.get(""));
					tmp.add(i);
					res.add(tmp);
				}				
			}
			
			//case 1 : ab and ba both exist
			add_one_result(str, i, map, res);   // will add only if str.reverse is in the map

			// case 2:  for aaaabcd, aaaa is palindrome and dcb exists (so we can attach dcb to the left, or similarly right)
			for(int k = 1; k < str.length(); k++) {
				String left = str.substring(0,k);
				String right = str.substring(k);				
				if(isValidPalindromeStr(left)) add_one_result(right, i, map, res);
				if(isValidPalindromeStr(right)) add_one_result(left, i, map, res);			
			}
			
		}
				
		return res;
	}
	
	private void add_one_result(String str, int i, Map<String, Integer> map, List<List<Integer>> res){
		String reverse_str = new StringBuilder(str).reverse().toString();
		if(map.containsKey(reverse_str) && map.get(reverse_str) != i) {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(i);
			tmp.add(map.get(reverse_str));
			res.add(tmp);
		}
	}

	////////////////////////////////////////
	/// if is palindrome number 
	////////////////////////////////////////
	public boolean ispalinum(int num){
		int k = 0;
		int p = num;
		
		while(p != 0) {
			k = k*10 + p%10;
			p = p/10;
		}
		
		return (k == num);
	}
	
	
	////////////////////////////////////////
	/// palindrome partition 
	////////////////////////////////////////
	
	public List<String> palindromePartitioning_on_model(String s) {
		if (s == null || s.length() == 0) return null;
	
		List<String> res = new ArrayList<String>();
		
		int n = s.length();
		boolean[][] ispalindr = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(s.charAt(i) == s.charAt(j) && j >= i) {
					if(j-i < 2) ispalindr[i][j] = true;
					else ispalindr[i][j] = ispalindr[i+1][j-1];	
					
					if (ispalindr[i][j]) {
						res.add(s.substring(i, j + 1));
					}
				}				
			}
		}
		
		return res;		
	}
	
	// just let the palindrome to grow as long as it can before the cut
	public int minCut_on_model(String s) {
		if (s == null || s.length() == 0) return 0;
	
		int res = 0;		
		int n = s.length();
		boolean[][] ispalindr = new boolean[n][n];
		int[] cut = new int[n];
		
		for(int j = 0; j < n; j++) {   // note that here we start with end point at j
			cut[j] = j;     // the max number of cut is to cut every one
			for(int i = 0; i < n; i++) {
				if(s.charAt(i) == s.charAt(j) && (j-i < 2 || ispalindr[i+1][j-1])) {
					ispalindr[i][j] = true;	
					
					if (i > 0) {
						cut[j] = Math.min(cut[j], cut[i-1]+1);
					} else {
						cut[j] = 0;
					}
				}				
			}
		}
		
		return cut[n-1];
		
	}
	
	public List<String> palindromePartitioning(String s) {
		if (s == null || s.length() == 0) return null;
	
		List<String> res = new ArrayList<String>();
		if(s.length() == 1) {
			res.add(s);
			return res;
		}

		int m = s.length();		
		boolean[][] dp = new boolean[m][m];
		dp[0][0] = true;
		
		// len is length, i is index of left boundary, j is index of right boundary
		for (int len = 1; len <= m; len++) {
			for (int i = 0; i <= m - len; i++) {
				int j = i + len - 1;
				if(s.charAt(i) == s.charAt(j)) {
					if(len == 1 || len == 2) dp[i][j] = true;
					else dp[i][j] = dp[i+1][j-1];
					
					if (dp[i][j]) res.add(s.substring(i, j + 1));
				} else {
					dp[i][j] = false;
				}				
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		palindrome test = new palindrome();
		
		if (test.isValidPalindromeStr("9Red rum, sir, is murder9")) System.out.println("yes it is a palindrome");
		else System.out.println("no it is not a palindrome");
		System.out.println();
		
		System.out.println("Longest Palindrome");
		String s = new String("bananas");
		String res = test.longestPalindrome_dp(s);
		System.out.println(res);
		res = test.longestPalindrome_dp_on_model(s);
		System.out.println(res);
		
		
		res = test.longestPalindrome_2(s);
		System.out.println(res);
		//String res = test.findlongestPalindrome(s);
		//System.out.print(res);
			
		System.out.println();
		System.out.println("Shortest Palindrome");
		String s_shortest = "abcd";
		String ans = test.shortestPalindrome_1(s_shortest);
		System.out.println(ans);
		
		ans = test.shortestPalindrome_2(s_shortest);
		System.out.println(ans);
		
		
		System.out.println();
		System.out.println("Palindrome Pairs");
		String[] words = {"bat", "tab", "cat", "abcdcba", ""};
		List<List<Integer>> anspair = test.palindromePairs(words);
		Iterator<List<Integer>> it = anspair.iterator();
		while(it.hasNext()) {
			List<Integer> e = it.next();
			System.out.println(e);
		}
		System.out.println();
		String[] words2 = {"abcd", "dcba", "lls", "s", "sssll"};
		anspair = test.palindromePairs(words2);
		it = anspair.iterator();
		while(it.hasNext()) {
			List<Integer> e = it.next();
			System.out.println(e);
		}
		
		System.out.println();
		System.out.println("Palindrome Number");
		int num = 121;
		if (test.ispalinum(num)) System.out.println(num + " is palindromenumber");
		else System.out.println(num + " is not a palindromenumber");

		System.out.println();
		System.out.println("Palindrome Partition");
		List<String> palindrome_partition = test.palindromePartitioning("aab");
		for(int i = 0; i < palindrome_partition.size(); i++) System.out.println(palindrome_partition.get(i));
		
		System.out.println();
		palindrome_partition = test.palindromePartitioning_on_model("aab");
		for(int i = 0; i < palindrome_partition.size(); i++) System.out.println(palindrome_partition.get(i));
		
		System.out.println();
		int mincut = test.minCut_on_model("aabaaabcd");
		System.out.println(mincut);
		
		System.out.println();
		int longest_can_be_built = test.longestPalindrome_can_be_built("abccccdd");
		System.out.println(longest_can_be_built);
		
		
		return;
	}
	
}
