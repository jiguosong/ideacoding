package bits.src;

public class sumof2integers {

	// treat same bits and different bits separately
	public int getSum(int a, int b) {
		int c = 0;
		
		while(b != 0) {
			c = a&b;   // all same bits will contribute to carry
			a = a^b;   // treat different bits separately, and the a is used as sum
			b = c << 1;  // use b as the carry now
		}
		
		return a;		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		sumof2integers test = new sumof2integers();
		int ans = test.getSum(1000,5505);
		System.out.println(ans);
	}

}
