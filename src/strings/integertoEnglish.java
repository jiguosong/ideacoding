package strings;

import java.util.*;

public class integertoEnglish {
	
	// Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
	
	public String numberToWords(int num) {
		assert num >= 0;
		assert num <= 1<<31-1;
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		init_map(map);
		
		if(num < 20) return map.get(num);
		
		StringBuilder sb = new StringBuilder();

		if(num/1000000000 != 0) {
			int tmp = num/1000000000;
			String tmp_s = convert(tmp, map);
			sb.append(tmp_s + " Billion");
			num = num%1000000000;
		}

		if(num/1000000 != 0) {
			int tmp = num/1000000;
			String tmp_s = convert(tmp, map);
			sb.append(tmp_s+ " Million");
			num = num%1000000;
		}

		if(num/1000 != 0) {
			int tmp = num/1000;
			String tmp_s = convert(tmp, map);
			sb.append(tmp_s + " Thousand");
			num = num%1000;
		}
	
		if(num > 0) sb.append(convert(num, map));
			
		return sb.toString().trim();
	}
	
	
	// 100 and 10 must go here. Since we can have 123 billion
	private String convert(int num, Map<Integer, String> map) {
		StringBuilder sb = new StringBuilder();
		
		if(num/100 != 0) {
			int tmp = num/100;
			sb.append(" " + map.get(tmp) + " Hundred");
			num = num%100;
		}		

		if(num >= 20) {
			int tmp = num - num%10;
			sb.append(" " + map.get(tmp));
			num = num%10;
		}
					
		if(num < 20 && num > 0) {
			sb.append(" " + map.get(num));
		} 
		
		return sb.toString();
	}
	
	private void init_map(Map<Integer, String> map) {
		map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		integertoEnglish test = new integertoEnglish();
		int num = 99997;
		String ans = test.numberToWords(num);
		System.out.println(ans);

	}

}
