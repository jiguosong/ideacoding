package strings;

import java.util.*;

public class groupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		if(strings == null || strings.length == 0) return null;
		List<List<String>> res = new ArrayList<List<String>>();
		
		Map<String, List<String>> map = new HashMap<String, List<String>>(); 
		
		for(int j = 0; j < strings.length; j++) {
			String str = strings[j];
			char[] char_str = str.toCharArray();
			StringBuilder sb = new StringBuilder();
			
			if(str.length() == 1) {
				sb.append('1');
			} else {
				for(int i = 1; i < char_str.length; i++) {
					int diff = str.charAt(i) - str.charAt(i-1);
					diff = (diff+26)%26;   // this makes the sign does not matter, e.g., "az" is same as "za"
					sb.append(Integer.toString(diff));
				}
			}
			
			String k = sb.toString();
			if(map.containsKey(k)) map.get(k).add(str);
			else {
				List<String> str_list = new ArrayList<String>();
				str_list.add(str);
				map.put(k, str_list);
			}
		}
		
		for(Map.Entry<String, List<String>> e : map.entrySet()) {
			List<String> tmp = e.getValue();
			System.out.println(tmp);
		}
		
		
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		groupShiftedStrings	test = new groupShiftedStrings();
		
		String[] strings = {"abc","bcd","xyz", "az","ba", "acef", "a","z"};		
		test.groupStrings(strings);

	}

}
