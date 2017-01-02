package bit.src;

public class bitsaddition {
	
	public int addDigits(int num) {
		if (num == 0) return 0;
		
		if (num < 10) return num;
		
		String num_s = String.valueOf(num);
		int sum = 0;
		for (int i = 0; i < num_s.length(); i++) {
			sum += num_s.charAt(i) - '0';
		}
		
		return addDigits(sum);		
	}

	public int addDigits_2(int num) {
		if (num == 0) return 0;		
		if (num < 10) return num;

		int tmp = num;
		int len = 0;
		while(tmp != 0) {
			tmp = tmp/10;
			len++;
		}
				
		int[] digits = new int[len];
		tmp = num;
		int sum = 0;
		for (int i = 0; i < len; i++){
			digits[i] = tmp%10;			
			sum += digits[i];
			tmp = tmp/10;
		}
		
		return addDigits_2(sum);
		
	}
	
	public int addDigits_3(int num) {
		return 1+(num-1)%9;	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		bitsaddition test = new bitsaddition();
		int ans = test.addDigits_3(38);
		System.out.println(ans);
	}

}
