package strings;

public class lengthoflastword {
	
	public int lengthOfLastWord(String s) { 
		if(s == null || s.length() == 0) return 0;
		
		//s.trim();
		int len = 0;
		boolean found = false;
		
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				found = true;
				len++;
			} else if(found) return len;
		}
		
		return len;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		lengthoflastword test = new lengthoflastword();
		String s = " this is an apple ";
		int ans = test.lengthOfLastWord(s);
		System.out.println(ans);

	}

}
