package math;

import java.util.*;

public class uglynumber {
	
	// prime factors only include 2, 3, 5
	public boolean isUgly(int num) {
		if(num == 0) return false;
		if(num == 1) return false;
		
		while(num%2 == 0) num /= 2;
		while(num%3 == 0) num /= 3;
		while(num%5 == 0) num /= 5;
		return num == 1;
	}
	
	//find the n-th ugly number
	public int nthUglyNumber(int n) {
		if(n <= 0) return 0;
		
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.add(1);
		
		int right_idx_2 = 0;
		int right_idx_3 = 0;
		int right_idx_5 = 0;
		
		while(tmp.size() < n) {
			int num_2 = tmp.get(right_idx_2)*2;
			int num_3 = tmp.get(right_idx_3)*3;
			int num_5 = tmp.get(right_idx_5)*5;
			
			int min = Math.min(num_2, Math.min(num_3, num_5));
			tmp.add(min);
			
			if(min == num_2) right_idx_2++;
			if(min == num_3) right_idx_3++;
			if(min == num_5) right_idx_5++;			
		}
		
		return tmp.get(n-1);
	}
	
	// find the nth super ugly number
	public int nthSuperUglyNumber(int n, int[] primes) {
		if(n <= 0) return 0;
		if(primes == null || primes.length == 0) return 0;
		int plen = primes.length;
		
		List<Integer> res = new ArrayList<Integer>();
		res.add(1);
		
		int[] right_idxes = new int[plen];
		Arrays.fill(right_idxes, 0);
		
		while(res.size() < n) {	
			int min = Integer.MAX_VALUE;
			List<Integer> tmp = new ArrayList<Integer>();
			
			for(int i = 0; i < plen; i++) tmp.add(res.get(right_idxes[i])*primes[i]);
			for(int i = 0; i < plen; i++) min = Math.min(min, tmp.get(i));
			for(int i = 0; i < plen; i++) if(min == tmp.get(i)) right_idxes[i]++;
			
			res.add(min);
		}
		
		System.out.println(res);
		
		return res.get(n-1);
	}
		

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		uglynumber test = new uglynumber();
		int num = 125;
		
		if(test.isUgly(num)) System.out.println("Yes ugly!");
		else System.out.println("No not ugly!");
		
		int ans = test.nthUglyNumber(10);
		System.out.println(ans);
		
		int[] primes = {2, 7, 13, 19};
		ans = test.nthSuperUglyNumber(12, primes);
		System.out.println(ans);
	}

}
