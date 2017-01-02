package bit.src;

public class findsinglenumber {
	
	// every one appears 2 times, except one
	public int singleNumber_2(int[] A) {
		if(A == null || A.length ==0) return 0;
		
		int res = 0;
		for(int e:A) res ^= e;
		
		return res;
	}
	
	// every one appears 3 times, except one
	public int singleNumber_3(int[] A) {
		if(A == null || A.length ==0) return 0;
		int res = 0;
		
		int[] cnt = new int[32];
		
		// by looping 32 first, we can update res immediately
		for(int i = 0; i < 32; i++) {
			for(int j = 0; j < A.length; j++) {
				if((A[j] & (1 << i)) != 0) {
					cnt[i] = (cnt[i] + 1)%3;
				}
			}
			res |= cnt[i]<<i;
		}
		
/*		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < 32; j++) {
				if((A[i] & (1 << j)) != 0) {
					cnt[j] = (cnt[j] + 1)%3;
				}
			}
		}
		
		for(int j = 0; j < 32; j++) {
			if(cnt[j] == 1) res |= 1<<j;
		}*/
				
		return res;
	}
	
	// every one appears 2 times, except two appear once
	public int[] singleNumber_22(int[] A) {
		if(A == null || A.length ==0) return null;
		
		int tmp = 0;
		for(int e:A) tmp^=e;
		tmp = tmp&(-tmp);   // right most bit
		
		int[] res = new int[2];
		
		for(int e:A) {
			if((tmp & e) != 0) res[0] ^= e;
			else res[1] ^= e;
		}
		
		return res;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findsinglenumber test = new findsinglenumber();
		int[] A = {1,2,3,4,99,3,2,1,4};
		int ans = test.singleNumber_2(A);
		//System.out.println(ans);
		
		int[] B = {1,1,3,2,3,1,3};
		ans = test.singleNumber_3(B);
		System.out.println(ans);
		
		int[] C = {9,1,3,2,3,4,9,1};
		int[] ans2 = test.singleNumber_22(C);
		System.out.println(ans2[0]);
		System.out.println(ans2[1]);
	}

}
