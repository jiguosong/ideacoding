package math;

public class adddigits {
	
	public int addDigits(int num) {
		if(num < 10) return num;
		
		int sum = 0;
		
		while(num > 0) {
			sum += num%10;
			num /=10;
		}
		
		return addDigits(sum);	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		adddigits test = new adddigits();
		int ans = test.addDigits(38);
		System.out.println(ans);

	}

}
