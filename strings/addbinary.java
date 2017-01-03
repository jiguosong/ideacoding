package strings;

public class addbinary {
	
	public String addBinary(String a, String b) {
		if(a == null || a.length() == 0) return b;
		if(b == null || b.length() == 0) return a;
		
		int a_right = a.length()-1;
		int b_right = b.length()-1;
		int carry = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(a_right >= 0 || b_right >= 0) {
			int a_val = 0;
			int b_val = 0;
			
			if(a_right >= 0) {
				a_val = a.charAt(a_right) - '0';
				a_right--;
			}
			
			if(b_right >= 0) {
				b_val = b.charAt(b_right) - '0';
				b_right--;
			}
			
			int tmp = a_val + b_val + carry;
			if(tmp == 2 || tmp == 3) {
				sb.append((char) ('0' + tmp - 2));
				//sb.append(String.valueOf(tmp-2));
				carry = 1;
			} else {
				sb.append((char) ('0' + tmp));
				//sb.append(String.valueOf(tmp));
				carry = 0;
			}
		}
		
		if(carry == 1) sb.append('1');
		
		return sb.reverse().toString();
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		addbinary test = new addbinary();
		String a = "11";
		String b = "1";
		String ans = test.addBinary(a, b);
		System.out.println(ans);

	}

}
