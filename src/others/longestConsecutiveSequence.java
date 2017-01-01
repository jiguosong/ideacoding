package others;

import java.util.*;

public class longestConsecutiveSequence {
	
	public static int longestConsecutive(int[] num) {
		if (num == null || num.length == 0) return 0;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int e : num) set.add(e);
		
		int left = 0;
		int right = 0;
		int maxLen = 1;
		
		for(int e : num) {
			if (set.contains(e)) {
				int tmp = e;
				while(set.contains(tmp-1)) {
					tmp = tmp - 1;
					set.remove(tmp);
					left++;					
				}
				
				tmp = e;
				while(set.contains(tmp+1)) {
					tmp = tmp + 1;
					set.remove(tmp);
					right++;
				}
				
				set.remove(e);
				maxLen = Math.max(maxLen, right+left+1);
			}
		}
		
		return maxLen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		longestConsecutiveSequence test = new longestConsecutiveSequence();
		int[] num = {100, 4, 200, 1, 3, 2};
		int ans = test.longestConsecutive(num);
		System.out.println(ans);
	}

}
