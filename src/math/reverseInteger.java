package math;

import java.util.*;

public class reverseInteger {
	
	public int reverse(int x) {
		int res = 0;
		
		try{
			while(x > 0) {
				res = res*10+x%10;  //  %10 digit bit
				x = x/10;   // all digits except last digit
			}
		} catch (InputMismatchException exception) {
			System.out.println("Error with Integer");
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reverseInteger test = new reverseInteger();
		int x = 123;
		int ans = test.reverse(x);
		
		System.out.println(ans);
	}

}
