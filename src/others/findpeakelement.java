package others;

public class findpeakelement {
	
	// Find local peak. You may imagine that num[-1] = num[n] = -∞
	
	// solution 1: O(n)
	public int findPeakElement(int[] num) {
		if(num == null || num.length == 0) return -1;		
		if(num.length == 1) return 0;
		
		boolean found = false;
		int res = -1;
		for(int i = 1; i < num.length-1; i++) {
			if(num[i] > num[i-1] && num[i] > num[i+1]) {
				found = true;
				res = i;
				break;
			}
		}
		
		if(!found) return (num[0] > num[num.length-1]) ? 0:num.length-1;
		else return res;
	}
	
	// solution 2: O(logn)  -- binary search
	public int findPeakElement_bs(int[] num) {
		if(num == null || num.length == 0) return -1;		
		if(num.length == 1) return 0;

		int left = 0;
		int right = num.length-1;
		
		while(left < right) {
			int mid = left + (right-left)/2;
			if(num[mid] > num[mid+1]) right = mid;
			else left = mid+1;
		}		
		return right;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findpeakelement test = new findpeakelement();
		int[] num = {1,2,5,2,3,9,10,2,3,1};
		int ans = test.findPeakElement(num);
		System.out.println(ans);
		
		ans = test.findPeakElement_bs(num);
		System.out.println(ans);
	}

}
