package bit.src;

public class maxproductofwordlenth {
	
	// all lower cases, so 26 bit is good for indicating the word presence
	public int maxProduct(String[] words) {
		if(words == null || words.length == 0) return 0;
		
		int[] presence = new int[words.length];
		
		for(int i = 0; i < words.length; i++) {
			String word = words[i];
			for(int j = 0; j < word.length(); j++) {
				presence[i] |= 1<<(word.charAt(j)-'a');
			}
		}
		
		int max = 0;
		for(int i = 0; i < words.length; i++) {
			for(int j = i+1; j < words.length; j++) {
				if((presence[i] & presence[j]) == 0) {  // totally different
					max = Math.max(max, words[i].length()*words[j].length());							
				}
			}
		}
		
		return max;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		maxproductofwordlenth test = new maxproductofwordlenth();
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		int ans = test.maxProduct(words);
		System.out.println(ans);
	}

}
