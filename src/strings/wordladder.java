package strings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, 
such that only one letter can be changed at a time and each intermediate word must exist in the dictionary
*/

class wordNode {
	String word;
	int steps;
	wordNode prev;
	wordNode(String inword, int steps, wordNode prev) {
		this.word = inword;
		this.steps = steps;
		this.prev = prev;
	}
}

public class wordladder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == null || endWord == null || wordList == null) return 0;
		
		if (wordList.contains(endWord) == false) wordList.add(endWord);		
		Deque<wordNode> queue = new ArrayDeque<wordNode>();
		queue.add(new wordNode(beginWord, 1, null));
		
		while (!queue.isEmpty()) {
			wordNode p = queue.remove();
			if (p != null) {
				if (p.word.equals(endWord)) return p.steps;				
				char[] k = p.word.toCharArray();
				for (int i = 0; i < k.length; i ++) {					
					char tmp = k[i];
					for (char c = 'a'; c != 'z'; c++) {
						k[i] = c;
						String newword = new String(k);
						if (wordList.contains(newword)) {
							queue.add(new wordNode(newword, p.steps+1, null));
							wordList.remove(newword);
						}
					}
					k[i] = tmp;					
				}
			}
		}
		
		return 0;
	}
	
	/*
		Given two words (start and end), and a dictionary, find all shortest transformation 
		sequence(s) from start to end
	*/
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		if (start == null || end == null || dict == null) return null;		
		if (dict.contains(end) == false) dict.add(end);
		
		List<List<String>> res = new ArrayList<List<String>>();
		Deque<wordNode> queue = new ArrayDeque<wordNode>();
		Set<String> unvisited = new HashSet<String>();
		Set<String> visited = new HashSet<String>();
		unvisited.addAll(dict);

		int prev_level = 1;
		int curr_level;
		int first_found_level = 0;
		queue.add(new wordNode(start, 1, null));
		while(!queue.isEmpty()) {
			wordNode currwordNode = queue.remove();
			if (currwordNode == null) continue;
			String currWord = currwordNode.word;
			curr_level = currwordNode.steps;
			
			if (prev_level < curr_level) {  // in the new level
				unvisited.removeAll(visited);  // if visited, this avoids repeating the same path 
				prev_level = curr_level;
			}
			
			if (currWord.equals(end)) {
				if (first_found_level == 0) first_found_level = curr_level; // in BFS this is smallest
				if (curr_level > first_found_level) continue; // reach to this word via a longer path. ignore the rest
				List<String> tmp = new ArrayList<String>();	
				tmp.add(0, currwordNode.word);
				while (currwordNode.prev != null) {
					currwordNode = currwordNode.prev;
					tmp.add(0, currwordNode.word);
				}
				res.add(tmp);
				continue;
			}
			
			char[] k = currWord.toCharArray();
			for (int i = 0; i < k.length; i++) {
				char tmp = k[i];
				for (char c = 'a'; c < 'z'; c++) {
					k[i] = c;
					String newword = new String(k);
					if (unvisited.contains(newword)) {
						queue.add(new wordNode(newword, currwordNode.steps+1, currwordNode));
						visited.add(newword);
					}
				}
				k[i] = tmp;
			}
		}
		
		return res;		
	}
        

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("Java:wordladder");
		My_Dictionary md = new My_Dictionary();
		Set<String> dict  = md.getDictSet();
		
		Set<String> small_dict = new HashSet<String>();
		List<String> ttt = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log"));
 		small_dict.addAll(ttt);
		
		wordladder test = new wordladder();		
		String beginWord = "hit";
		String endWord = "cog";
		
//		int res = test.ladderLength(beginWord, endWord, small_dict);		
//		System.out.println(res);
		
		List<List<String>>  res_str = test.findLadders(beginWord, endWord, dict);
		System.out.println(res_str);
		if(res_str == null || res_str.size() == 0) System.out.println("not found");
		else System.out.println(res_str.get(0).size()); 
	}

}
