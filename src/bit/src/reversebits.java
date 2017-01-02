package bit.src;

public class reversebits {
	
	public int reverseBits(int n) {
		for(int i = 0; i < 16; i++) {
			n = swap_bit(n, i, 32-i-1);
		}
		
		return n;
	}
	
	private int swap_bit(int n, int left, int right) {
		int a = (n >> left) & 1;
		int b = (n >> right) & 1;
		
		if(a != b) n ^= (1 << left | 1 << right);
		
		return n;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reversebits test = new reversebits();
		int ans = test.reverseBits(43261596);
		System.out.println(ans);
	}

}
