package strings;

public class zigZagConversion {
	
	// convert a string to zigzag format
	public String convert(String s, int numRows) {
		if(s == null || s.length() == 0 || numRows <= 1) return s;
		
		StringBuilder sb = new StringBuilder();
		
		int diff = 2*numRows-2; // every diagonal number is a row and col. If top and bottom ones are missing, we have 2 row less.
		for(int i = 0; i < numRows; i++) {   // process the string for each row
			for(int j = i; j < s.length(); j += diff) {
				sb.append(s.charAt(j));
				int mid = j + diff - 2*i;    // count from the next col, and then go back up and down twice row number 
				if(i != 0 && i != numRows-1 && mid < s.length()) sb.append(s.charAt(mid));
			}
		}
		
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		zigZagConversion test = new zigZagConversion();
		String s = "PAYPALISHIRING";
		int numRows = 3;
		String ans = test.convert(s, numRows);
		System.out.println(ans);

	}

}
