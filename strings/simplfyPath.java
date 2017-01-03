package strings;

import java.util.*;

public class simplfyPath {
	
	public String simplifyPath(String path) {
		if(path == null || path.length() == 0) return null;
		
		Deque<String> stack = new ArrayDeque<String>();
		
		int left = 0;
		int len = path.length();
		
		// push each "/XXX" into the stack
		for(int i = 0; i < len; i++) {
			char s = path.charAt(i);
			if(s == '/') {
				stack.push(path.substring(left, i));
				left = i;
			} else if(i == len-1) {
				stack.push(path.substring(left));
			}
		}
		
		List<String> result = new ArrayList<String>();		
		left = 0;
		while(!stack.isEmpty()) {
			String tmp = stack.pop();
			if(tmp.equals("/") || tmp.equals("/.")) continue;   // case liek "//" or "/./"
			else if(tmp.equals("/")) left++;                  // case like "a/../"
			else {
				if(left > 0) left--;
				else result.add(0, tmp);
			}
		}
		
		if(result.isEmpty()) return "/";
		
		StringBuilder sb = new StringBuilder();
		for(String e : result) sb.append(e);
		return sb.toString();		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		simplfyPath test = new simplfyPath();
		
		String path;
		//path = "/home/";
		path = "/a/./b/../../c/";
		//path = "/../";
		//path = "/home//foo/";
		//path = "./a/b/c/../../d";
		String ans = test.simplifyPath(path);
		System.out.println(ans);

	}

}
