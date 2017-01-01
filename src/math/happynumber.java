package math;

import java.util.*;

public class happynumber {
	
	public boolean isHappy(int n) {
		if(n == 0) return false;
		if(n == 1) return true;
		
		Set<Integer> set = new HashSet<Integer>();
		
		while(!set.contains(n)) {
			set.add(n);		   // this needs to be called first	
			int sum = 0;
			while(n > 0) {
				sum += (n%10)*(n%10);
				n = n/10;
			}
			if(sum == 1) return true;
			n = sum;
		}
		
		return false;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		happynumber test = new happynumber();
		if(test.isHappy(19)) System.out.println("Is Happy");
		else System.out.println("Not Happy");
	}

}
