package math;

import java.util.*;

public class fractiontoRecurringDecimal {
	
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator == 0 && denominator != 0) return "0"; 
		if(denominator == 0) return "";
		
		String res = "";
		
		int sign = 0;
		if(numerator > 0 && denominator < 0) sign = -1;
		else if(numerator < 0 && denominator > 0) sign = -1;
		else sign =1;
		
		long num = (long)numerator;
		long den = (long)denominator;
		
		long q = num/den;
		if(num%den == 0) return String.valueOf(q); 
		else res = res + String.valueOf(q);
		
		res = res + ".";
		long remainder = (num%den)*10;
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		while(remainder != 0) {
			if(map.containsKey(remainder)) {
				int offset = map.get(remainder);
				String str1 = res.substring(0,offset);
				String str2 = res.substring(offset);
				res = str1 + "(" + str2 + ")"; 
				return res;
			} 
			
			map.put(remainder, res.length());
			q = remainder/den;
			res = res + String.valueOf(q);
			remainder = (remainder%den)*10;		
		}
		
		if(sign == 1) return res;
		else return "-1"+res;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		fractiontoRecurringDecimal test = new fractiontoRecurringDecimal();
		String ans;
		ans = test.fractionToDecimal(1,2);
		System.out.println(ans);
		ans = test.fractionToDecimal(2,1);
		System.out.println(ans);
		ans = test.fractionToDecimal(2,3);
		System.out.println(ans);
	}

}
