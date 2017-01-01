package others;

public class increasingtriplet {
	
	// the_smallest_so_far < the_second_smallest_so_far < current

	public boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length == 0) return false;
		
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		for(int e : nums) {
			if(e < min1) min1 = e;
			else if(e < min2) min2 = e;
			else return true;
		}
		
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		increasingtriplet test = new increasingtriplet();
		int[] nums = {1, 2, 3, 4, 5};
		int[] nums2 = {5,4,3,2,1};
		if (test.increasingTriplet(nums2)) System.out.println("Yes there is an increasing triplet");
		else System.out.println("No there is not an increasing triplet");

	}

}
