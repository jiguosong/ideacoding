package others;

import java.util.*;

public class reversePolishNotation {

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) return 0;
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int i = 0;
		while(i < tokens.length) {
			String c = tokens[i];
			i++;
			if (c.charAt(0) >= '0' || c.charAt(0) <= 9) {
				stack.push(Integer.valueOf(c));
				continue;
			}			
			int num2 = stack.pop();
			int num1 = stack.pop();
			
			switch(c) {
			case "+":
				stack.push(Integer.valueOf(num1)+Integer.valueOf(num2));
				break;
			case "-":
				stack.push(Integer.valueOf(num1)-Integer.valueOf(num2));
				break;
			case "*":
				stack.push(Integer.valueOf(num1)*Integer.valueOf(num2));
				break;
			case "/":
				stack.push(Integer.valueOf(num1)/Integer.valueOf(num2));
				break;
			default:
			}
		}
		
		return stack.pop();
	
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reversePolishNotation test = new reversePolishNotation();
		
		String[] tokens = new String[] { "2", "1", "+", "9", "-" };
		int ans = test.evalRPN(tokens);
		System.out.println(ans);
		

	}

}
