package combinatorics;

import java.util.*;

public class separateNumber {
	
	public List<List<Integer>> separateto7Number(String s) {
		if (s == null || s.length() == 0) return null;
		List<List<Integer>> final_res = new ArrayList<List<Integer>>();
		
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> tmp = new ArrayList<String>();
		
		separateto7Number_helper(s, 0, tmp, res);
		
		Iterator<List<String>> it = res.iterator();
		while(it.hasNext()) {
			List<String> p = it.next();
			Iterator<String> it_num = p.iterator();
			List<Integer> q = new ArrayList<Integer>();
			while(it_num.hasNext()) {
				q.add(Integer.valueOf(it_num.next()));
			}
			final_res.add(q);
		}
		
		return final_res;
	}
	
	
	private void separateto7Number_helper(String s, int level, List<String> tmp, List<List<String>> res) {
		if (tmp.size() > 7 || tmp.size() + s.length() - level + 1 < 7) return;
		if (tmp.size() == 7 && level == s.length()) {
			List<String> t = new ArrayList<String>(tmp);
			res.add(t);
			return;
		}
		
		for (int i = 1; i <= 2; i++) {
			if (level + i > s.length()) break;
			if (i > 1 && s.charAt(level) == '0') break;
			String k = s.substring(level, level+i);
			if (Integer.valueOf(k) < 1 || Integer.valueOf(k) > 60) break;
			tmp.add(k);
			separateto7Number_helper(s, level+i, tmp, res);
			tmp.remove(tmp.size()-1);			
		}		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		separateNumber test = new separateNumber();
		String s = "12345678";
		List<List<Integer>> ans = test.separateto7Number(s);
		
		Iterator<List<Integer>> it = ans.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
