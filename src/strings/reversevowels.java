package strings;

public class reversevowels {
	
	public String reverseVowels(String s) {
		if(s == null || s.length() == 0) return null;
		assert (s != null);   // test
		
		char[] s_chars = s.toCharArray();
		int l = 0;
		int r = s_chars.length-1;
		while(l < r) {
			if (l < s.length() && !isvowel(s_chars[l])) l++;
			if (r >= 0 && !isvowel(s_chars[r])) r--;	
			char tmp = s_chars[l];
			s_chars[l] = s_chars[r];
			s_chars[r] = tmp;
			l++;
			r--;
		}
		
		//return s_chars.toString();  // this will cause error if s_chars is null
		return String.valueOf(s_chars);   // this will not cause error if null
	}
	
	
	private boolean isvowel(char c){
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
				c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reversevowels test = new reversevowels();
		String s = "leetcode";
		String ans = test.reverseVowels(s);
		
		System.out.println(ans);

	}

}
