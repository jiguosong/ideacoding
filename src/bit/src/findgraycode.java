package bit.src;

import java.util.*;

public class findgraycode {
	
	/* 例举grey code序列，并找规律 :
		 n = 0: 0
		 n = 1: 0, 1
		 n = 2: 00, 01, 11, 10  (0, 1, 3, 2)
		 n = 3: 000, 001, 011, 010, 110, 111, 101, 100 (0, 1, 3, 2, 6, 7, 5, 4)
		 以n = 3为例，grey code中前4个包括了n = 2的所有gray code。后4个则是前4个逆序后加上2^2。

		 推广：n = i的grey code的前一半包括了n = i-1的所有grey code，而后一半则为前一半逆序后家上2^(i-1)。*/

	public List<Integer> grayCode(int n) {
		if(n == 0) {
			List<Integer> res = new ArrayList<Integer>();
			res.add(0);
			return res;
		}
		
		List<Integer> res = grayCode(n-1);
		int addition = 1<<(n-1);
		
		for(int i = res.size()-1; i >=0; i--) {
			res.add(addition+res.get(i));
		}
		
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findgraycode test = new findgraycode();
		int n = 2;
		List<Integer> ans = test.grayCode(n);
		for(Integer e:ans){
			System.out.println(Integer.toBinaryString(e));	
		}
		
	}

}
