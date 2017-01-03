package combinatorics.src;

import java.util.*;

public class allsubsets {
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if(S == null || S.length == 0) return null;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		
		subsets_helper(S, 0, tmp, res);
		
		return res;
	}
	
	private void subsets_helper(int[] S, int level, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> res) {
		ArrayList<Integer> k = new ArrayList<Integer>(tmp);
		res.add(k);
		
		for(int i = level; i < S.length; i++) {
			tmp.add(S[i]);
			subsets_helper(S, i+1, tmp, res);
			tmp.remove(tmp.size()-1);
		}		
	}
	
	public ArrayList<ArrayList<Integer>> subsets_iterative(int[] S) {
		if(S == null || S.length == 0) return null;
		
		Arrays.sort(S);
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	
		for(int e:S) {
			ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
		
			for(ArrayList<Integer> a:res) tmp.add(new ArrayList<Integer>(a));
			for(ArrayList<Integer> a:tmp) a.add(e);
			
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(e);
			tmp.add(single);	
			
			res.addAll(tmp);
		}
		
		res.add(new ArrayList<Integer>());   // this shoud be called last, not first
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		allsubsets test = new allsubsets();
		int[] S = {1,2,3};
		ArrayList<ArrayList<Integer>>  ans = test.subsets_iterative(S);
		
		Iterator <ArrayList<Integer>> it = ans.iterator();
		while(it.hasNext()) {
			ArrayList<Integer> tmp = it.next();
			System.out.println(tmp);
		}

	}

}
