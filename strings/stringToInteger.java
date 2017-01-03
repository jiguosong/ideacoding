package strings;

public class stringToInteger {
	
	public int convertStrToInt(String s) throws NumberFormatException {
		if (s == null || s.length() == 0) return 0;
		boolean sign = (s.charAt(0) == '-') ? true:false;
		int res = 0;
		int tmp = 0;
		boolean firstZero = false;
		
		s = s.trim();  // remove leading and trailing white space
		if (s == null || s.length() == 0) return 0;
		
		if (s.charAt(0) == '0') firstZero = true;
				
		for(int i = (sign) ? 1:0; i< s.length(); i++) {
			if (firstZero && s.charAt(i) == '0') continue;
			else if (firstZero && s.charAt(i) != '0') firstZero = false;
			
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				throw new NumberFormatException();
			};
			
			tmp = s.charAt(i) - '0';
			res = res*10+tmp;
		}
		
		if (sign) res = -res;;
		
		if (res > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (res < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return res;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		stringToInteger test = new stringToInteger();
		String s = " 0023843 ";
		int ans = 0;
		try {
			ans = test.convertStrToInt(s);
			System.out.println(ans);
		} catch (NumberFormatException n){
			System.out.println("Wrong! check the format");
		}
	}

}
