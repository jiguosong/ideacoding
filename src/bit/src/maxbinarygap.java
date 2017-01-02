package bit.src;

public class maxbinarygap {
	
	public static int getGap2(int N) {
		int max = 0;
		int count = -1;
		int r = 0;
	 
		while (N > 0) {
			// get right most bit & shift right
			r = N & 1;
			N = N >> 1;
	 
			if (0 == r && count >= 0) {
				count++;
			}
	 
			if (1 == r) {
				max = count > max ? count : max;
				count = 0;
			}
		}
	 
		return max;
	}
	
	public int getGap(int N) {
		int curr = 0;
		int prev = -1;
		
		int gap = Integer.MIN_VALUE;
		
		while(N > 0) {
			int k = N&(-N);   // get the last 1 bit (and the whole value, say 1000)
			N = N & (N-1);  // set bits after right most bit to 0s (inclusive)
			curr = (int) (Math.log(k)/Math.log(2));   // get the position of last 1 bit (say 3)	, in Java we need do log(a)/log(b)
			if(prev != -1) gap = Math.max(gap, Math.abs(curr - prev)-1);	
			prev = curr;			
		}
		
		return gap;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		maxbinarygap test = new maxbinarygap();
		int N = 129;   // 0x81
		int ans = test.getGap(N);
		System.out.print(ans);

	}

}
