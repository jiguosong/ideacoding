package dp;

public class scrambleString {
	
	public boolean isScramble(String s1, String s2) {
		if(s1 == null || s2 == null ) return false;
		if(s1.length() != s2.length()) return false;
		
		// this is important!!!!
		if(s1.length()==0 || s1.equals(s2))
	        return true;
		
		for(int k = 1; k < s1.length(); k++) {
			String s11 = s1.substring(0, k);
			String s12 = s1.substring(k);
			String s21 = s2.substring(0, k);
			String s22 = s2.substring(k);
			String s21_new = s2.substring(s2.length()-k);
			String s22_new = s2.substring(0, s2.length()-k);
			
			if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
			if(isScramble(s11, s21_new) && isScramble(s12, s22_new)) return true;
		}
		
		return false;
	}

	
	//TODO: this is a copied version from internet. I need write this later
	// res[k][i][j] where i is the start char in s1, j  is the start char in s2, and n is the current substring length
	// res[k][i][j] indicates if the substring(i, i+k) and substring(j, j+k) is scramble to each other
    public boolean isScramble_DP(String s1, String s2) {
        //Check lengths.
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
            
        int L = s1.length();
        boolean[][][] scramble = new boolean[L][L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++)
                if (s1.charAt(i) == s2.charAt(j))
                    scramble[0][i][j] = true;
        }
        
        for (int k = 2; k <= L; k++) {
            for (int i = L - k; i >= 0; i--) {
                for (int j = L - k; j >= 0; j--) {
                    boolean canScramble = false;
                    for (int m = 1; m < k; m++) {
                        canScramble = (scramble[m - 1][i][j] && scramble[k - m - 1][i + m][j + m]) || (scramble[m - 1][i][j + k -m] && scramble[k - m - 1][i + m][j]);
                        if (canScramble)
                            break;
                    }
                    scramble[k - 1][i][j] = canScramble;
                }
            }
        }
        
        return scramble[L - 1][0][0];
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scrambleString test = new scrambleString();
		
		String s1 = "great";
		String s2 = "rgtae";
		if(test.isScramble(s1, s2)) System.out.println("is scramble");
		else System.out.println("not scramble");

		if(test.isScramble_DP(s1, s2)) System.out.println("is scramble");
		else System.out.println("not scramble");
}

}
