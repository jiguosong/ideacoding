package dp.src;

import dp.BSTNode;

import java.util.*;

// there is some issue with this code. Passing by value.

public class countSmallerNumbersAfterSelf {
	
	public List<Integer> countSmaller(int[] nums) {
		if(nums == null || nums.length == 0) return null;
		
		Integer[] res = new Integer[nums.length];
		BSTNode root = null;
		for(int i = nums.length-1; i >= 0; i--) {
			root = insert(root, nums[i], res, i, 0);
		}
		return Arrays.asList(res);
	}

	private BSTNode insert(BSTNode root, int val, Integer[] res, int i, int preSum) {
		if(root == null) {
			root = new BSTNode(val,0);			
			res[i] = preSum;
		} else if(root.val > val) {
			root.smaller++;
			root.left = insert(root.left, val, res, i, preSum);
		} else {
			root.right = insert(root.right, val, res, i, preSum+root.smaller+(root.val<val?1:0));
		}
		
		return root;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		countSmallerNumbersAfterSelf test = new countSmallerNumbersAfterSelf();
		int[] nums = {5,2,6,1};
		List<Integer> ans = test.countSmaller(nums);
		System.out.println(ans);

	}

}
