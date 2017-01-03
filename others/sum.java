package others;

import java.util.*;

// 2sum, 3sum, 4sum and 3sum closet

public class sum {
	
	public static sum instance() {return p;}
	private static final sum p = new sum();
	protected sum(){};
}
//
//public class sums extends sum {
//	public int threeSumClosest(int[] nums, int target) {
//		if (nums == null || nums.length == 0) return 0;	
//		
//		int min = Integer.MAX_VALUE;
//		int res = 0;
//		
//		Arrays.sort(nums);
//		
//		for(int i = 1; i < nums.length; i++) {
//			int curr = nums[i-1];
//			int left = i;
//			int right = nums.length-1;
//			int diff = 0;
//			while(left < right) {
//				int sum  = nums[left] + nums[right] + curr;
//				
//				diff = Math.abs(sum - target);
//				if(diff == 0) return target;				
//				if (diff < min) {
//					min = diff;
//					res = sum;
//				}
//				
//				if(sum <= target) {
//					left++;
//				} else {
//					right--;
//				}
//			}
//		}
//		
//		return res;
//	}	
//		
//	
//	public List<List<Integer>> fourSum(int[] nums, int target) {
//		if (nums == null || nums.length == 0) return null;		
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//
//		Arrays.sort(nums);
//		
//		for (int i = 0; i < nums.length-1; i++) {
//			int tmp_target = nums[i];
//			int[] tmp_nums = Arrays.copyOfRange(nums, i+1, nums.length);
//			List<List<Integer>> tmp_list = threeSum(tmp_nums, target-tmp_target);
//			if (!tmp_list.isEmpty()) {
//				Iterator <List<Integer>> it = tmp_list.iterator();
//				while(it.hasNext()) {
//					List<Integer> tmp_e = it.next();
//					tmp_e.add(0,tmp_target);
//				}
//				result.addAll(tmp_list);
//			}
//		}
//		
//		return result;		
//	}	
//	
//	
//	public List<List<Integer>> threeSum(int[] nums, int target) {
//		if (nums == null || nums.length == 0) return null;		
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		
//		// this is not necessary, only because of using list in twoSum_ptr
//		List<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < nums.length; i++) {
//			list.add(nums[i]);
//		}
//		
//		Collections.sort(list);
//		
//		for (int i = 0; i < list.size()-1; i++) {
//			int tmp_target = list.get(i);
//			List<Integer> tmp_list = list.subList(i+1, list.size());
//			int[] res = twoSum_ptr(tmp_list, target-tmp_target);
//			if (res[0] != -1) {
//				List<Integer> tmp = new ArrayList<Integer>();
//				tmp.add(tmp_target);
//				tmp.add(tmp_list.get(res[0]));
//				tmp.add(tmp_list.get(res[1]));
//				result.add(tmp);
//			}
//		}
//		
//		return result;		
//	}	
//	
//	
//	// array of integer is sorted
//	public int[] twoSum_ptr(List<Integer> A, int sum){
//		if (A == null || A.size() == 0) return null;		
//		int[] res = {-1, -1};		
//		
//		int left = 0;
//		int right = A.size()-1;
//		
//		while(left < right) {
//			int tmp = A.get(left) + A.get(right);
//			if (tmp == sum) {
//				res[0] = left;
//				res[1] = right;
//				break;
//			} else if (tmp < sum) {
//				left++;
//			} else {
//				right--;
//			}
//		}
//		
//		return res;
//		
//	}
//	
//	public int[] twoSum_map(List<Integer> A, int sum){
//		if (A == null || A.size() == 0) return null;		
//		int[] res = {-1, -1};
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		
//		for (int i = 0; i < A.size(); i++) {
//			if (map.containsKey(A.get(i))) {
//				int index = map.get(A.get(i));
//				res[0] = index;
//				res[1] = i;
//				break;
//			} else {
//				map.put(sum - A.get(i), i);
//			}
//			
//		}
//		
//		return res;
//	}
//	
//	public static void src(String[] args){
//		sums test = new sums();
//		
//		Integer[] array = {10, 2, 3, 4, 5, 6};
//		List<Integer> input = Arrays.asList(array);			
//		int[] res = test.twoSum_map(input, 5);
//		System.out.println(array[res[0]]);
//		System.out.println(array[res[1]]);
//		System.out.println();
//
//		Integer[] array2 = {1, 2, 3, 4, 5, 6};
//		List<Integer> input2 = Arrays.asList(array2);			
//		int[] res2 = test.twoSum_ptr(input2, 6);
//		System.out.println(array2[res2[0]]);
//		System.out.println(array2[res2[1]]);
//		System.out.println();
//		
//		int[] array3 = {-1, 0, 1, 2, -1, -4};
//		List<List<Integer>> ans = test.threeSum(array3, 0);		
//		Iterator<List<Integer>> it = ans.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		System.out.println();
//		
//		int[] array4 = {1, 0, -1, 0, -2, 2};
//		List<List<Integer>> ans4 = test.fourSum(array4, 0);		
//		it = ans4.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		System.out.println();
//		
//		int[] array5 = {-1, 2, 1, -4};
//		int ans5 = test.threeSumClosest(array5, 1);		
//		System.out.println(ans5);
//		
//		return;
//	}
//}
//

