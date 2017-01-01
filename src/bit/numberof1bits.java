package bit;

public class numberof1bits {
	
	public int rangeBitwiseAnd(int m, int n) {
		if(m > n) return 0;
		
		while(n > m) n = n&(n-1);
		return m&n;
	}
	
	public int hammingWeight(int n) {
		int cnt = 0;
		
		while(n > 0) {
			n = n&(n-1);
			cnt++;
		}
		
		return cnt;
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		numberof1bits test = new numberof1bits();
		int ans = test.hammingWeight(11);
		System.out.println(ans);
		
		ans = test.rangeBitwiseAnd(5,7);
		System.out.println(ans);
		
	}

}
