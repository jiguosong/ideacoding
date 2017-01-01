package strings;

public class oneeditdistance {
	
	public boolean isOneEditDistance(String s, String t) {
		if(s == null && t != null) return false;
		if(s != null && t == null) return false;

		int m = s.length();
		int n = t.length();
		if(Math.abs(m-n) >1) return false;
		
		int count = 0;
		int i = 0;
		int j = 0;
		
		while(i < m && j < n) {
			if(s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				count++;
				if(count > 1) return false;
				if(m < n) j++;
				else if(m > n) i++;
				else {
					i++;
					j++;
				}
			}
		}
		
		if(i < m || j < n) {
			count++;
		}
		
		return count <= 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		oneeditdistance test = new oneeditdistance();
		String s = "gesek";
		String t = "geek";
		if(test.isOneEditDistance(s, t)) System.out.println("is one edit distance");
		else System.out.println("not one edit distance");
		

	}

}
