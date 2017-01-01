package others.containmostwater;

class containmostwater {
	int maxArea(int[] height) {
		if(height == null || height.length < 2) return 0;
		
		int left = 0;
		int right = height.length-1;
		int max = 0;
		
		while(left < right) {
			int w = right-left;
			int h = Math.min(height[left], height[right]);
			max = Math.max(max, w*h);
			if (height[left] < height[right]) left++;
			else right--;
		}
		
		return max;
	}
}