package dp;

public class maximumwordlenproduct {
	// Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
	// where the two words do not share common letters. You may assume that each word will contain 
	// only lower case letters. If no such two words exist, return 0.
	 public int maxProduct(String[] words) {
		 if(words == null || words.length == 0) return 0;
		 
		 int res = 0;
		 int[] digits = new int[words.length];  // 26 bits in each digits[i] can represent if a word has a letter
		 for(int i = 0; i < words.length; i++) {
			 for(int j = 0; j < words[i].length(); j++) {
				 digits[i] |= 1 << (words[i].charAt(j)-'a');
			 }
			 
			 for(int k = 0; k < i; k++) {
				 if((digits[i] & digits[k]) == 0) {
					 res = Math.max(res, words[i].length()*words[k].length());
				 }
			 }			 
		 }
		 return res;
	 }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		maximumwordlenproduct test = new maximumwordlenproduct();
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		int ans = test.maxProduct(words);
		System.out.println(ans);
		
		String[] words2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		int ans2 = test.maxProduct(words2);
		System.out.println(ans2);
		

	}

}
