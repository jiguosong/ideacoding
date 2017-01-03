package combinatorics.src;

import java.util.*;

public class restoreIPaddress {

	public List<String> restoreIpAddresses(String s) {
		if (s == null || s.length() == 0) return null;
		
		List<String> final_res = new ArrayList<String>();
		
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> tmp = new ArrayList<String>();
		
		restoreIpAddresses_helper(s, 0, tmp, res);	
		
				
		// convert res to final_res
		Iterator<List<String>> it = res.iterator();
		while(it.hasNext()) {
			List<String> k = it.next();
			StringBuilder t = new StringBuilder();
			Iterator<String> it_tmp = k.iterator();
			while(it_tmp.hasNext()) {
				t.append(it_tmp.next() + ".");
			}
			String e = t.toString();
			final_res.add(e.substring(0, e.length()-1));
		}
		
		return final_res;
	}
	
	private void restoreIpAddresses_helper(String s, int level, List<String> tmp, 
											   List<List<String>> res) {
		if (tmp.size() >= 4 && level != s.length()) return;
		if (tmp.size() + s.length() - level + 1 < 4 ) return;
		if (tmp.size() == 4 && level == s.length()) {
			List<String> kk = new ArrayList<String>(tmp);
			res.add(kk);
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			if (level + i > s.length()) break;
			if (i > 1 && s.charAt(level) == '0') break;	
			String curr_num = s.substring(level, level+i);
			if (Integer.valueOf(curr_num) > 255) break;
			tmp.add(curr_num);
			restoreIpAddresses_helper(s, level+i, tmp, res);
			tmp.remove(tmp.size() - 1);
		}		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		restoreIPaddress test = new restoreIPaddress();
		String s = "25525511135";
		List<String> ans = test.restoreIpAddresses(s);
		
		Iterator<String> it = ans.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
