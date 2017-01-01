package others;

public class findminimumRotatedArray {
	
/*	Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	Find the minimum element.You may assume no duplicate exists in the array.
*/
	public int findMin(int[] num) {
		if(num == null || num.length == 0) return -1;
		if(num.length == 1) return num[0];
		
		int left = 0;
		int right = num.length-1;
		
		if(num[left] < num[right]) return num[left]; 
		
		while(left <= right) {
			if(right - left == 1) return num[right];
			int mid = left + (right-left)/2;
			if(num[mid] < num[left]) right = mid;
			else left = mid;
		}
		
		return num[left];	
	}

	// same as aboe, but duplicates are allowed
	public int findMinDup(int[] num) {
		if(num == null || num.length == 0) return -1;
		if(num.length == 1) return num[0];
		
		int left = 0;
		int right = num.length-1;
		
		while(left <= right) {
			while(num[left] == num[right] && left != right) left++;
			
			if(num[left] <= num[right]) return num[left];

			int mid = left + (right-left)/2; 
			if(num[mid] < num[left]) right = mid;
			else left = mid+1;
		}
		
		return -1;	
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findminimumRotatedArray test = new findminimumRotatedArray();
		int[] num = {4, 5, 6, 7, -1, 1, 2,3};
		int ans = test.findMin(num);
		System.out.println(ans);

		int[] num2 = {4, 4, 5, 7, 1, 1, 2,3, 4,4};
		int ans2 = test.findMinDup(num2);
		System.out.println(ans2);

	}

}
