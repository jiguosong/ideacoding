package others;

import java.util.ArrayList;
import java.util.List;

public class flipgame {
	
	// The game ends when a person can no longer make a move and therefore the other person will be the winner.
	public boolean canWin(String s) {
		if(s == null || s.length() == 0) return false;
		
		return canWin_helper(s.toCharArray());		
	}
	
	private boolean canWin_helper(char[] s) {
		for(int i = 1; i < s.length; i++) {
			if(s[i] == '+' && s[i-1] == '+') {
				s[i] = '-';
				s[i-1] = '-';				
				boolean res = canWin_helper(s);				
				s[i] = '+';
				s[i-1] = '+';				
				if(res == false) return true;				
			}
		}
		return false;	 // when there is no consecutive "++" to flip
	}
	
	public List<String> generatePossibleNextMoves(String s) {
		if(s == null || s.length() == 0) return null;
		
		List<String> res = new ArrayList<String>();
		char[] s_chars = s.toCharArray();
		for(int i = 1; i < s_chars.length; i++) {
			if(s_chars[i] == s_chars[i-1] && s_chars[i] == '+') {
				s_chars[i-1] = '-';
				s_chars[i] = '-';				
				res.add(String.valueOf(s_chars));
				s_chars[i-1] = '+';
				s_chars[i] = '+';
			}
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		flipgame test = new flipgame();
		String s = "+++--++-+-++";
		
		List<String> ans = test.generatePossibleNextMoves(s);
		System.out.println(ans);
		
		if(test.canWin(s)) System.out.println("Win");
		else System.out.println("Loose");

	}

}
