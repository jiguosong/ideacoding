package math;

public class excelSheetColumnNumber {
	
	public int titleToNumber(String s) {
		if(s == null || s.length() == 0) return 0;
		
		int res = 0;
		int k = 0;
		int i = s.length()-1;
		while(i >=0) {
			res = res+(int)Math.pow(26, k)*(s.charAt(i)-'A'+1);
			i--;
			k++;
		}
		
		return res;		
	}
	
	public String convertToTitle(int n) {
		if(n <= 0) return null;
		
		StringBuilder sb = new StringBuilder();
		
		while(n > 0) {
			char c = (char) (n%26+'A'-1);
			n /= 26;
			sb.append(c);
		}
		
		return sb.reverse().toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		excelSheetColumnNumber test = new excelSheetColumnNumber();
		String s = "AAB";
		int ans = test.titleToNumber(s);
		System.out.println(ans);
		
		String str = test.convertToTitle(704);
		System.out.println(str);
	}

}
