package dp;

public class removekdigits {
	// Given a non-negative integer num represented as a string, remove k digits 
	// from the number so that the new number is the smallest possible.
	public String removeKdigits(String num, int k) {
		if(num == null || num.length() == 0) return null;
		if(k <= 0) return num;
		
		int n = num.length();
		StringBuilder sb = new StringBuilder();
		
		String res = "";
		
		for(int i = 0; i < n; i++) {
			char c = num.charAt(i);
			while(sb.length() != 0 && k > 0 && sb.charAt(sb.length()-1) > c) {
				sb.deleteCharAt(sb.length()-1);
				k--;
			}
			sb.append(c);			
		}
		sb.setLength(n-k);
		while(sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
		if(sb.length() == 0) return "0";
		else return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		removekdigits test = new removekdigits();
		String num = "1432219";
		int k = 3;
		String ans = test.removeKdigits(num, k);
		System.out.println(ans);
		
		num = "10200";
		k = 1;
		ans = test.removeKdigits(num, k);
		System.out.println(ans);
		
		num = "10";
		k = 2;
		ans = test.removeKdigits(num, k);
		System.out.println(ans);
	}

}
