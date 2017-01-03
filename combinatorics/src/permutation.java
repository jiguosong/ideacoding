package combinatorics.src;

import java.util.*;

public class permutation {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		
		if (nums == null || nums.length == 0) return res;
		
		permute_helper(nums, 0, visited, tmp ,res);
		
		return res;
	}
	
	private void permute_helper(int[] nums, int level, boolean[] visited,
								List<Integer> tmp, List<List<Integer>> res)
	{
		if (tmp.size() == nums.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {   // for all permutation, we do not need level. Start from 0 anyway
			if (visited[i] == true) continue;			
			visited[i] = true;
			
			tmp.add(nums[i]);
			permute_helper(nums, i+1, visited, tmp, res);
			
			visited[i] = false;
			tmp.remove(tmp.size()-1);
		}		
		return;
	}
	
	
	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();		
		
		List<Integer> intList = new ArrayList<Integer>();
		for (int index = 0; index < nums.length; index++) intList.add(nums[index]);
		
		permute2_helper(intList, 0, res);
		
		return res;		
	}
	
	
	private void permute2_helper(List<Integer> nums, int level, List<List<Integer>> res)
	{
		if(level == nums.size()) res.add(new ArrayList<Integer>(nums));
		
		for(int i = level; i < nums.size(); i++) {
			swap(nums, level, i);
			permute2_helper(nums, level+1, res);
			swap(nums, i, level);
		}		
	}
	
	private void swap(List<Integer> nums, int i, int j){
		Integer tmp = nums.get(i);
		nums.set(i,nums.get(j));
		nums.set(j, tmp);
	}
	/*
	
	public List<List<Integer>> permute3(int[] nums) {
		if (nums == null || nums.length == 0) return null;
		
		List<Integer> intList = new ArrayList<Integer>();
		for (int index = 0; index < nums.length; index++) intList.add(nums[index]);
		
		return permute3_helper(intList);
		
	}
	
	private  List<List<Integer>> permute3_helper(List<Integer> nums)
	{		
		if(nums == null || nums.size() == 0) return new ArrayList<List<Integer>>(1);
		int first = nums.get(0);
		nums = nums.subList(1, nums.size());
		List<List<Integer>> res = permute3_helper(nums);
		for(List<Integer> e:res) {
			System.out.println(e);
			for(int i = 0; i < e.size(); i++) {
				e.add(i, first);
				res.add(e);
				e.remove(i);
			}			
		}
		
		return res;
	}*/
//
//
//	public static void main(String[] args) {
//		permutation test = new permutation();
//		int[] nums = new int[] {1,2,3};
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		result = test.permute(nums);
//		System.out.println(result);
//
//		result = test.permute2(nums);
//		System.out.println(result);
//
//	}
}
