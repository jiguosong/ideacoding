package dp;

import java.util.Arrays;

public class trappingrain {
	public int trap(int[] height) {
		int res = 0;
		if (height == null || height.length == 0) return res;
		
		int[] left_max = new int[height.length];
		int[] right_max = new int[height.length];
		Arrays.fill(left_max, 0);
		Arrays.fill(right_max, 0);
		left_max[0] = height[0];
		right_max[height.length-1] = height[height.length-1];
		
		int max = height[0];
		// left to right (the max so far at i)
		for (int i = 1; i < height.length; i++) {
			if (height[i] > max) {
				left_max[i] = height[i];
				max = height[i];
			} else {
				left_max[i] = max;
			}
		}
		
		max = height[height.length-1];
		// right to left (the max so far at i)
		for (int i = height.length - 2; i > 0; i--) {
			if (height[i] > max) {
				right_max[i] = height[i];
				max = height[i];
			} else {
				right_max[i] = max;
			}
		}
		
		for (int i = 1; i < height.length; i++) {
			res += Math.min(left_max[i], right_max[i]) - height[i];
		}
		
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		trappingrain test = new trappingrain();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int ans = test.trap(height);
		System.out.println(ans);
		
	}

}
