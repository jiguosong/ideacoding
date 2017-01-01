package dp;

public class removeduplicatedletters {

	// this is like the sliding window of max sum
	public String removeDuplicateLetters(String s) {
		if(s == null || s.length() == 0) return null;
		if(s.length() == 1) return s;
		
		int[] count = new int[256];
		boolean[] visited = new boolean[256];
		for(int i = 0; i < s.length(); i++) count[s.charAt(i)-'a']++;
		String res = "0";
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			count[c-'a']--;
			if(visited[c-'a'] == true) continue;  // in the result already
			char last_c = res.charAt(res.length()-1);  // start looking at the previous chars
			while(s.charAt(i) < last_c && count[last_c-'a'] > 0) {
				visited[res.charAt(res.length()-1)-'a'] = false;
				res = res.substring(0, res.length()-1);
				last_c = res.charAt(res.length()-1);
			}
			
			res += s.charAt(i);
			visited[c-'a'] = true;
		}
		return res.substring(1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		removeduplicatedletters test = new removeduplicatedletters();
		String s = "cbacdcbc";
		String ans = test.removeDuplicateLetters(s);
		System.out.println(ans);

	}

}
