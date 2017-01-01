package combinatorics;

import java.util.*;

public class combinations {
	
	// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        
        if (n <= 0 || n < k) return res;
        
        combine_helper(n, k , 1, tmp, res);
        
        return res;
    }
	
	public static void combine_helper(int n, int k, int level, List<Integer> tmp, List<List<Integer>> res) {
		if (tmp.size() == k) {
			res.add(new ArrayList<Integer>(tmp));
			return;			
		}
		
		for (int i = level; i <= n; i++) {
			tmp.add(i);
			combine_helper(n, k , i+1, tmp, res);
			tmp.remove(tmp.size()-1);
		}
		
		return;		
	}
	
	//The same repeated number may be chosen unlimited number of times.
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0) return null;
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(candidates);
		
		combinationSum_helper(candidates, 0, tmp, res, target);
		
	    return res;
	}
	
	private void combinationSum_helper(int[] candidates, int level, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> res, int target) {
		if(target < 0) return;
		if(target == 0) {
			ArrayList<Integer> k = new ArrayList<Integer>(tmp);
			res.add(k);
			return;
		}
		
		for(int i = level; i < candidates.length; i++) {
			tmp.add(candidates[i]);
			combinationSum_helper(candidates, i, tmp, res, target-candidates[i]);
			tmp.remove(tmp.size()-1);
		}
		return;		
	}
	
	//  Each number in C may only be used ONCE in the combination
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0) return null;
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(candidates);
		
		combinationSum_helper2(candidates, 0, tmp, res, target);
		
	    return res;
	}
	
	private void combinationSum_helper2(int[] candidates, int level, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> res, int target) {
		if(target < 0) return;
		if(target == 0) {
			ArrayList<Integer> k = new ArrayList<Integer>(tmp);
			res.add(k);
			return;
		}
		
		for(int i = level; i < candidates.length; i++) {
			if(i > level && candidates[i] == candidates[i-1]) continue;
			tmp.add(candidates[i]);
			combinationSum_helper2(candidates, i+1, tmp, res, target-candidates[i]);
			tmp.remove(tmp.size()-1);
		}
		return;		
	}
	
	// Find all possible combinations of k numbers that add up to a number n, 
	// given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();	        
		if (k <= 0 ) return res;	        
		
		helper(res, tmp, k, 1, n);
	        
		return res;
	}
	
	public void helper(List<List<Integer>> result, List<Integer> curr, int k, int start, int sum){
	    if(sum<0){
	        return;
	    }
	 
	    if(sum==0 && curr.size()==k){
	        result.add(new ArrayList<Integer>(curr));
	        return;
	    }
	 
	    for(int i=start; i<=9; i++){
	        curr.add(i);
	        helper(result, curr, k, i+1, sum-i);
	        curr.remove(curr.size()-1);
	    }
	}
		
	// Given an integer array with all positive numbers and no duplicates, 
	// find the number of possible combinations that add up to a positive integer target.
	public int combinationSum4(int[] nums, int target) {
		if(nums == null || nums.length == 0) return 0;
		
		int[] num_comb = new int[target+1];
		num_comb[0] = 1;
		
		for(int i = 0; i <= target; i++) {
			for(int e:nums) {
				if(i + e <= target) num_comb[i+e] += num_comb[i]; 
			}
		}
		
		return num_comb[target];
		
	}
	
	
	public static void main(String[] args){
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		System.out.println("Java:combination");
		
		combinations test = new combinations();
		
		int n = 4;
		int k =2;
		
		result = test.combine(n, k);		
		for (List<Integer> E : result){
			System.out.println(E);
		}
		
		System.out.println();
		ArrayList<ArrayList<Integer>> combsum = new ArrayList<ArrayList<Integer>>();
		int[] candidates = {2,3,6,7};
		int target = 7;
		combsum = test.combinationSum(candidates, target);
		Iterator<ArrayList<Integer>> it = combsum.iterator();
		while(it.hasNext()) {
			ArrayList<Integer> tmp = it.next();
			System.out.println(tmp);
		}
		
		System.out.println();
		int[] candidates2 = {10,1,2,7,6,1,5};
		target = 8;
		combsum = test.combinationSum2(candidates2, target);
		it = combsum.iterator();
		while(it.hasNext()) {
			ArrayList<Integer> tmp = it.next();
			System.out.println(tmp);
		}
		
		System.out.println();
		k = 3;
		n = 7;
		result = test.combinationSum3(k, n);
		Iterator<List<Integer>> it3 = result.iterator();
		while(it3.hasNext()) {
			List<Integer> tmp = it3.next();
			System.out.println(tmp);
		}
		
		System.out.println();
		int[] candidates4 = {1,2,3};
		target = 7;
		int numWays = test.combinationSum4(candidates4, target);
		System.out.println(numWays);
	}
	
}
