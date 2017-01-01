package bit;

import java.util.*;

public class repeatedDNA {
	
	public List<String> findRepeatedDnaSequences(String s) {
		if(s == null || s.length() == 0) return null;
		
		List<String> res = new ArrayList<String>();
		
		int n = s.length();
		if(n < 10) {
			res.add(s);
			return res;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		Set<Integer> tmp = new HashSet<Integer> ();
		Set<Integer> track = new HashSet<Integer> ();
		
		int hash = 0;
		for(int i = 0; i < n; i++){ 
			if(i < 9) hash = (hash << 2) + map.get(s.charAt(i));
			else {
				hash = (hash << 2) + map.get(s.charAt(i));
				//hash = hash &  (1 << 20) - 1; 
				hash = hash & (1<<20)-1;
				System.out.println(Integer.toBinaryString(hash));
				
				if(tmp.contains(hash) && !track.contains(hash)) {  // more than once
					res.add(s.substring(i-9, i+1));
					track.add(hash);
				} else {
					tmp.add(hash);
				}				
			}
		}
		
		return res;		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		repeatedDNA test = new repeatedDNA();
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> ans = test.findRepeatedDnaSequences(s);
		System.out.println(ans);
	}

}
