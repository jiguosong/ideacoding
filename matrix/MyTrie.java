package matrix;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class MyTrie {
	private static class TriNode {
		boolean isString = false;
		Map<Character, TriNode> leaves = new HashMap<Character, TriNode>();
		private Map<Character, TriNode> getLeaves() {
			return this.leaves;
		}
		private void setIsString() {
			this.isString = true;
		}
	}	
	TriNode root = new TriNode();  // dummy root
	
	public boolean insert(String word) {
		if (word == null || word.length() == 0) return false;
		TriNode p = root;	
		Character c = null;
		Map<Character, TriNode> leaves = null;		
		for(int i = 0; i < word.length(); i++) {
			leaves = p.getLeaves();
			c = word.charAt(i);
			if (!leaves.containsKey(c)) leaves.put(c, new TriNode());
			p = leaves.get(c);
		}
		
		if (p.isString == true) {
			return false;
		} else {
			p.setIsString();
			return true;
		}		
	}
	
	public boolean search(String word) {
		if (word == null || word.length() == 0) return false;		
		
		TriNode p = root;	
		Character c = null;
		Map<Character, TriNode> leaves = null;
		for(int i = 0; i < word.length(); i++) {
			leaves = p.getLeaves(); 
			c = word.charAt(i);
			if (!leaves.containsKey(c)) return false;
			p = leaves.get(c);
		}
		return p.isString;		
	}
	
	public boolean startwith(String word) {
		if (word == null || word.length() == 0) return false;	
		
		TriNode p = root;	
		Character c = null;
		Map<Character, TriNode> leaves = null;
		for(int i = 0; i < word.length(); i++) {
			leaves = p.getLeaves();
			c = word.charAt(i);
			if (!leaves.containsKey(c)) return false;
			p = leaves.get(c);
			
		}
		return true;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		My_Dictionary dict = new My_Dictionary();
		Set<String> my_dict = dict.getDictSet();		
		Iterator<String> it = my_dict.iterator();
		
		MyTrie test = new MyTrie();
		while(it.hasNext()) test.insert(it.next());	
		
//		if (!test.insert("aasdkjhp9i")) System.out.println("wrong insert");
//		else System.out.println("yes insert");
//		if (!test.insert("aasdkjhp9")) System.out.println("wrong insert");
//		else System.out.println("yes insert");

		if (!test.search("soccer")) System.out.println("wrong search");
		else System.out.println("yes search");
		if (!test.startwith("ke")) System.out.println("wrong startwith");
		else System.out.println("yes startwith");
		
	}

}
