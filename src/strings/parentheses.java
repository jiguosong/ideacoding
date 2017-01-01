package strings;

import java.util.*;

public class parentheses {
	
	////////////////////////////////////////
	/// if is a valid parentheses 
	////////////////////////////////////////
 	public boolean isValid(String s) {
		if (s == null || s.length() == 0) return false;
		
		Map<Character,Character> map = new HashMap<Character,Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		
		Deque<Character> stack = new ArrayDeque<Character>();
		
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				if(stack.isEmpty()) return false;
				char c = stack.pop();
				if (c != map.get(chars[i])) return false;
			} else if (map.containsValue(chars[i])) {
				stack.push(chars[i]);				
			}
		}
		
		return stack.isEmpty();
	}

	
	////////////////////////////////////////
	/// Given a string containing just the characters '(' and ')', 
 	/// find the length of the longest valid parenthesis 
	////////////////////////////////////////
 	// this is actually a dp solution. Based on my model, any previous valid parenthesis can not be in the stack, they must already be all popped properly.
 	// either there are some invalid heading ")", or just none. We use stack.peek to find the previous boundary
 	
 	public int longestValidParentheses_on_model(String s) {
 		if (s == null || s.length() == 0) return 0;
 		Deque<int[]> stack = new ArrayDeque<int[]>();
 		
 		int res = Integer.MIN_VALUE;
 		for(int i = 0; i < s.length(); i++) {
 			char c = s.charAt(i);
 			if(c == '(') {    // 0 for '('
 				int[] tmp = {0, i};
 				stack.push(tmp);
 			} else {          // 1 for ')'
 				if(stack.isEmpty() || stack.peek()[0] == 1) {
 	 				int[] tmp = {1, i};
 	 				stack.push(tmp);
 				} else {
 					stack.pop();
 					int len = 0;
 					if(stack.isEmpty()) len = i+1;
 					else len = i - stack.peek()[1];
 					
 					res = Math.max(res, len);
 				}
 			}
 		}
 		
 		return res;
 	}
 	
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) return 0;
		
		Deque<int[]> stack = new ArrayDeque<int[]>();
		
		int res  = Integer.MIN_VALUE;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') {
				int[] tmp = {i, 0};           // 0 is for left "("
				stack.push(tmp);
			} else {
				if(stack.isEmpty() || stack.peek()[1] == 1) {
					int[] tmp = {i, 1};       // 1 is for right ")"
					stack.push(tmp);
				} else {
					stack.pop();
					int current_len = 0;
					if(stack.isEmpty()) current_len = i+1;   // all previous valid ones have been popped
					else current_len = i - stack.peek()[0];
					res = Math.max(res, current_len);
				}
			}
		}
		
		return res;		
	}

	
	////////////////////////////////////////
	/// Remove the minimum number of invalid parentheses in order to make the input string valid. 
	////////////////////////////////////////
	// BFS (is better than DFS)
	
	/*On the first level, there's only one string which is the input string s, let's say the length of it is n, to check whether it's valid, we need O(n) time. On the second level, we remove one ( or ) from the first level, so there are C(n, n-1) new strings, each of them has n-1 characters, and for each string, we need to check whether it's valid or not, thus the total time complexity on this level is (n-1) x C(n, n-1). Come to the third level, total time complexity is (n-2) x C(n, n-2), so on and so forth...
	Finally we have this formula:
	T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).*/
	
	public List<String> removeInvalidParentheses_bfs(String s) {
		if(s == null || s.length() == 0) return null;
		List<String> res = new ArrayList<String>();
		Deque<String> queue = new ArrayDeque<String>();
		Set<String> set = new HashSet<String>();
		
		queue.offer(s);
		set.add(s);
		boolean found_in_curr_level = false;
		
		while(!queue.isEmpty()) {
			String str = queue.poll();
			
			if(isValid(str)) {
				res.add(str);
				found_in_curr_level  = true;  
			}
			
			if(found_in_curr_level) continue;    // if the current str is already a palindrome, no need to cut/remove anymore
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) != '(' && str.charAt(i) != ')') continue;
				String tmp = str.substring(0,i) + str.substring(i+1);   // remove char(i)
				if(!set.contains(tmp)) {   // if not visited this str before
					queue.offer(tmp);
					set.add(tmp);
				}
			}
		}
		
		return res;
		
	}
	
	// DFS
	 int max = 0;	
	 public List<String> removeInvalidParentheses(String s) {
		 if(s == null || s.length() == 0) return null;
		 
		 List<String> res = new ArrayList<String>();
		 
		 removeInvalidParentheses_helper(s, "", 0, 0, res);
		 
		 return res;
	 }
	
	 // stack is used to indicate how many added into the right_str
	 private void removeInvalidParentheses_helper(String left_str, String right_str, 
			 										  int stack, int maxleft, List<String>res) {
		 if(left_str.length() == 0) {       // after update every left string
			 if (stack == 0 && right_str.length() != 0) {   // valid and not null
				 if(maxleft > max) max = maxleft;           // update the max length of a valid string
				 if(max == maxleft && !res.contains(right_str)) res.add(right_str);   // only add the longest ones, so that minimum is removed !!! 
			 }
			 return;
		 }
		 
		 if(left_str.charAt(0) == '(') {
			 removeInvalidParentheses_helper(left_str.substring(1), right_str + "(", stack+1, maxleft+1, res);  // include this "("
			 removeInvalidParentheses_helper(left_str.substring(1), right_str, stack, maxleft, res);            // not include this "("
		 } else if (left_str.charAt(0) == ')') {
			 if(stack > 0) removeInvalidParentheses_helper(left_str.substring(1), right_str + ")", stack-1, maxleft, res);
			 removeInvalidParentheses_helper(left_str.substring(1), right_str, stack, maxleft, res);
		 } else {
			 removeInvalidParentheses_helper(left_str.substring(1), right_str+String.valueOf(left_str.charAt(0)), stack, maxleft, res);
		 }
		 
		 return;
	 }
	 
	 // generate valid parentheses from n pairs of parentheses
	 // think in DP model
	 public List<String> generateParenthesis(int n) {
		 if(n <= 0) return null;
		 
		 List<String> res = new ArrayList<String>();
		 generateParenthesis_helper(res, "", n, n);
		 return res;
	 }

	 private void generateParenthesis_helper(List<String> res, String s, int left, int right) {
		 if(left > right) return;
		 
		 if(left == 0 && right == 0) {
			 res.add(s);
			 return;
		 }
		 
		 if(left > 0) generateParenthesis_helper(res, s+'(', left-1, right);
		 if(right > 0) generateParenthesis_helper(res, s+')', left, right-1);
		 
		 return;
	 }
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		parentheses test = new parentheses();
		
		System.out.println("check valid parentheses");		
		String s1 = "()[]{}";
		String s2 = "([)]";	
		if (test.isValid(s1)) System.out.println(s1+" Valid");
		else System.out.println(s1+" Not Valid");		
		if (test.isValid(s2)) System.out.println(s2+" Valid");
		else System.out.println(s2+" Not Valid");		
		
		System.out.println();
		String s3 = ")()())";
		System.out.println("longest parentheses of " + s3);		
		int longestpa = test.longestValidParentheses(s3);
		System.out.println(longestpa);
		longestpa = test.longestValidParentheses_on_model(s3);
		System.out.println(longestpa);

		System.out.println();
		String s4 = "()())()";
		System.out.println("remove invalid parentheses from " + s4);
		List<String> ans = test.removeInvalidParentheses(s4);
		System.out.println(ans);
		
		System.out.println();
		String s5 = "()())()";
		System.out.println("remove invalid parentheses from " + s5);
		List<String> ans2 = test.removeInvalidParentheses_bfs(s5);
		System.out.println(ans2);	
		
		System.out.println();
		int n = 3;
		System.out.println("generate parentheses from " + n + " pairs of parenthesis");
		List<String> ans3 = test.generateParenthesis(n);
		System.out.println(ans3);	
		}
	
	}
