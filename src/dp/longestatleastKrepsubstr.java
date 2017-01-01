package dp;

// Find the length of the longest substring T of a given string (consists of lowercase letters only) 
// such that every character in T appears no less than k times.
// Input: s = "ababbc", k = 2 Output: 5 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
public class longestatleastKrepsubstr {	
	public int longestSubstringAtLeastKRep(String s, int k) {
		if(s == null || s.length() == 0 || k <= 0) return 0;
		
		int[] count = new int[256];
		int all_above_k = 0;
		int max = 0;
		int left = 0;
		int n = s.length();
		
		for(int i = 0; i < n-k; i++) {
			for(int j = i; j < n; j++) {
				char c = s.charAt(j);
				int idx = c-'a';
				count[idx]++;
				if(count[idx] < k) all_above_k |= (1<<idx);
				else all_above_k &= ~(1<<idx);
				
				if(all_above_k == 0) {     // if all previous chars appear more than k times
					max = Math.max(max, j-i+1);	
					left = j;
				}
			}
			i = left;			
		}
		
		return max;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		longestatleastKrepsubstr test = new longestatleastKrepsubstr();
		String s = "ababbc";
		int k = 2;
		int ans = test.longestSubstringAtLeastKRep(s, k);
		System.out.println(ans);		
	}

}
