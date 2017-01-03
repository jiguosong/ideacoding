package combinatorics.src;

import java.util.*;

public class stringPermutation {

	public List<List<String>> findAllStringPermutatoin(String s){
		if (s == null || s.length() == 0) return null;
		
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> tmp = new ArrayList<String>();
		boolean[] visited = new boolean[s.length()];
		
		findAllStringPermutatoin_helper(s, tmp, res, visited);
		
		return res;
	}
	
	private void findAllStringPermutatoin_helper(String s, List<String> tmp, List<List<String>> res, boolean[] visited){
		if (s == null || s.length() == 0) return;
		if (tmp.size() == s.length()) {
			res.add(new ArrayList<String>(tmp));
			return;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (visited[i] == true) continue;				
			visited[i] = true;
			tmp.add(String.valueOf(s.charAt(i)));
			findAllStringPermutatoin_helper(s, tmp, res, visited);
			tmp.remove(tmp.size()-1);
			visited[i] = false;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		stringPermutation test = new stringPermutation();
		String s = "abc";
		List<List<String>> ans = test.findAllStringPermutatoin(s);

		Iterator<List<String>> it = ans.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
