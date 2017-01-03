package math;

public class integerbreak {
	
	public int integerBreak(int n) {
		int[] max_product_of_int_i = new int[n+1];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i+j <= n) {
					int tmp = Math.max(i, max_product_of_int_i[i])*Math.max(j, max_product_of_int_i[j]);
					max_product_of_int_i[i+j] = Math.max(max_product_of_int_i[i+j], tmp);
				}
			}
		}
		
		return max_product_of_int_i[n];
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		integerbreak test = new integerbreak();
		int ans = test.integerBreak(10);
		
		System.out.println(ans);


	}

}
