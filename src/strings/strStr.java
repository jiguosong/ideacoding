package strings;

public class strStr {
	public int strStr_violent1(String haystack, String needle) {
		if(haystack == null || haystack.length() == 0) return -1;
		if(needle == null || needle.length() == 0) return -1;
		
		int m = haystack.length();
		int n = needle.length();		
		if(n > m) return -1;
		
		int i, j, k;
		for(i = 0; i < m - n + 1; i++) {
			k = i;
			for(j = 0; j < n; j++) {
				if(haystack.charAt(k) != needle.charAt(j)) break;
				k++;
			}
			if(j == n) return i;
		}
		
		return -1;
	}
	
	
	public int strStr_violent2(String haystack, String needle) {
		if(haystack == null || haystack.length() == 0) return -1;
		if(needle == null || needle.length() == 0) return -1;
		
		int m = haystack.length();
		int n = needle.length();		
		if(n > m) return -1;
		
		int i = 0;
		int j = 0;
		while(i < m && j <n) {
			if(haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}			
		}
		
		if(j == n) return i - j;
		else return -1;		
	}
	
	// http://blog.csdn.net/v_july_v/article/details/7041827
	public int strStr_KMP(String haystack, String needle) {
        if(haystack==null || needle==null)    
            return 0;
 
		int h = haystack.length();
		int n = needle.length();
	 
		if (n > h)
			return -1;
		if (n == 0)
			return 0;
	 
		int[] next = getNext(needle);
		int i = 0;
	 
		while (i <= h - n) {
			int success = 1;
			for (int j = 0; j < n; j++) {
				if (needle.charAt(0) != haystack.charAt(i)) {
					success = 0;
					i++;
					break;
				} else if (needle.charAt(j) != haystack.charAt(i + j)) {
					success = 0;
					i = i + j - next[j - 1];  // when not match, j right move next[j]
					break;
				}
			}
			if (success == 1)
				return i;
		}
	 
		return -1;
	}
 
//	calculate KMP array , or next array
	public int[] getNext(String needle) {
		int[] next = new int[needle.length()];
		next[0] = 0;
	 
		for (int i = 1; i < needle.length(); i++) {
			int index = next[i - 1];
			while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
				index = next[index - 1];
			}
	 
			if (needle.charAt(index) == needle.charAt(i)) {
				next[i] = next[i - 1] + 1;
			} else {
				next[i] = 0;
			}
		}
	 
		return next;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		strStr test = new strStr();
		
		String haystack = "thisisatest";
		String needle = "test";
		int ans = test.strStr_violent1(haystack, needle);
		System.out.println(ans);

		ans = test.strStr_violent2(haystack, needle);
		System.out.println(ans);

		ans = test.strStr_KMP(haystack, needle);
		System.out.println(ans);

	}

}
