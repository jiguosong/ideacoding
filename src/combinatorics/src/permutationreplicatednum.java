package combinatorics.src;

import java.util.*;

public class permutationreplicatednum {
	public Set<Integer> permutationRepnum(int N) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		
		int[] nums = convertInttoArray(N);
	
		boolean[] visited = new boolean[nums.length];		
		permutationRepnum_helper(nums, 0, visited, tmp, res);
		
		Set<Integer> set = new HashSet<Integer>();
		Iterator<List<Integer>> it = res.iterator(); 
		while (it.hasNext()) {
			List<Integer> k = it.next();
			if (k.get(0) == 0) k.remove(0);
			int tmp_ans = convertList2Int(k);	
			set.add(tmp_ans);
		}		
		return set;
	}
	
	private void permutationRepnum_helper(int[] nums, int level, boolean[] visited, 
											  List<Integer> tmp, List<List<Integer>> res) {
		if (nums == null || nums.length == 0) return;
		if (tmp.size() == nums.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] == true) continue;
			tmp.add(nums[i]);
			visited[i] = true;
			permutationRepnum_helper(nums, level+1, visited, tmp, res);
			visited[i] = false;
			tmp.remove(tmp.size()-1);
		}
	}
	
	private int convertList2Int(List<Integer> list) {
		if (list == null || list.size()== 0) return 0;
		
		int sz = list.size();
		int N = 0;		
		for(int i = 0; i < sz; i++) {
			N = N*10 + list.get(i);
		}		
		return N;
	}
	
	private int[] convertInttoArray(int num) {
		List<Integer> list = new ArrayList<Integer>();
		
		while(num != 0) {
			int a = num%10;
			list.add(0, a);
			num = num/10;
		}	
		
		int[] res = new int[list.size()];
		for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
	
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java:duplicatednumer permutation");
		permutationreplicatednum test = new permutationreplicatednum();
		Set<Integer> res = test.permutationRepnum(12321);
		
		Iterator<Integer> it = res.iterator(); 
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}

}
