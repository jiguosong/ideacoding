package strings;

public class longestcommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) return null;
		
		for(int i = 0; i < strs[0].length(); i++) {
			for(int j = 0; j < strs.length-1; j++) {
				String t1 = strs[j];
				String t2 = strs[j+1];
				if(i >= t1.length() || i >= t2.length() ||  t1.charAt(i) != t2.charAt(i)) {
					return t1.substring(0, i);
				}
			}
		}

		return strs[0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		longestcommonPrefix test = new longestcommonPrefix();
		
		String[] strs = {"abcdefgh", "abcefgh"};
		String ans = test.longestCommonPrefix(strs);
		System.out.println(ans);
	}

}
