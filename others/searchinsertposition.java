package others;

public class searchinsertposition {

	public int searchInsert(int[] A, int target) {
		if(A == null || A.length == 0) return -1;
		 
		int left = 0;
		int right = A.length-1;
		int mid = 0;
		int prev = 0;
		 
		while(left <= right) {
			mid = left + (right-left)/2;
		 	if(A[mid] == target) return mid;
		 	if(A[mid] < target) {
		 		left = mid +1;
		 	} else {
		 		right = mid-1;
		 	}
		}
		 
		return left;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		searchinsertposition test = new searchinsertposition();
		int[] A = {1,3,5,6};
		int target = 0;
		int ans = test.searchInsert(A, target);
		System.out.println(ans);

	}

}
