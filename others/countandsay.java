package others;

public class countandsay {
	
	public String countAndSay(int n) {
		if(n == 0) return "zero";
		
		String res;
		if(n < 0) res = "-";
		else res = "";
		
		String n_str = String.valueOf(Math.abs(n));
		
		int i = 1;
		int count = 1;
		while(i < n_str.length()) {
			if(n_str.charAt(i-1) == n_str.charAt(i)) count++;
			else {
				res = res + String.valueOf(count) + n_str.charAt(i-1);
				count = 1;
			}
			i++;
		}
		
		res = res + String.valueOf(count) + n_str.charAt(n_str.length()-1);
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		countandsay test = new countandsay();
		int n = -222339889;
		String ans = test.countAndSay(n);
		System.out.println(ans);
	}

}
