package strings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import strings.MyTrie;
import strings.My_Dictionary;

public class wordsearch {
	
	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board[0].length == 0) return false;
		if (word == null || word.length() == 0) return false;
		
		int row = board.length;
		int col = board[0].length;
		
		boolean[][] visited = new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (exist_helper(board, word, i, j, 0, visited)) return true;
			}
		}
		
		return false;
    }
	
	private boolean exist_helper(char[][] board, String word, int row, int col, 
			   int level, boolean[][] visited) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ) return false;
		if (word.charAt(level) != board[row][col]) return false;
		if (visited[row][col] == true) return false;
		
		if (level == word.length()-1) return true;		
		
		visited[row][col] = true;
		if (exist_helper(board, word, row+1, col, level+1, visited) ||			
			exist_helper(board, word, row-1, col, level+1, visited) ||
			exist_helper(board, word, row, col-1, level+1, visited) ||
			exist_helper(board, word, row, col+1, level+1, visited)) {
			return true;	
		}
		visited[row][col] = false;
		
		return false;
}	
	
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		if (board.length == 0 || board[0].length == 0) return res;
		if (words == null || words.length == 0) return res;
		
		MyTrie trie = new MyTrie();
		for(String s:words) {
			trie.insert(s);
		}
		
		int row = board.length;
		int col = board[0].length;
		
		boolean[][] visited = new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				findWords_helper(board, trie, i, j, 0, visited, "", res);
			}
		}
		
		Set<String> tmp = new HashSet<String>();
		tmp.addAll(res);
		List<String> list = new ArrayList<String>(tmp);
	
		return list;		
    }
	
	private void findWords_helper(char[][] board, MyTrie trie, int row, int col, 
						   int level, boolean[][] visited, String tmp, List<String> res) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ) return;

		if (visited[row][col] == true) return;
		tmp = tmp + board[row][col];
		if (!trie.startwith(tmp.toString())) return;
		if (trie.search(tmp.toString())) res.add(tmp.toString());
		
		visited[row][col] = true;
		findWords_helper(board, trie, row+1, col, level+1, visited, tmp, res);			
		findWords_helper(board, trie, row-1, col, level+1, visited, tmp, res);
		findWords_helper(board, trie, row, col-1, level+1, visited, tmp, res);
		findWords_helper(board, trie, row, col+1, level+1, visited, tmp, res);
		visited[row][col] = false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("Java:wordsearch");
		wordsearch test = new wordsearch();
		char[][] board = {{'A', 'B', 'C', 'E'},
						  {'S', 'F', 'C', 'S'},
						  {'A', 'D', 'E', 'E'}};
		for (int i = 0; i < board.length*board[0].length; i++) {
			if (i%board[0].length == 0) System.out.println();
			System.out.print(board[i/board[0].length][i%board[0].length]);
		}
	
		String word = "FCE";
		System.out.println("\n\n"+word);
		if (test.exist(board, word)) System.out.println("\nYes");
		else System.out.println("\nNo");
		
		
		wordsearch test2 = new wordsearch();
		char[][] board2 = {{'o', 'a', 'a', 'n'},
						  {'e', 't', 'a', 'e'},
						  {'i', 'h', 'k', 'r'},
						  {'i', 'f', 'l', 'v'}};
		
		for (int i = 0; i < board2.length*board2[0].length; i++) {
			if (i%board2[0].length == 0) System.out.println();
			System.out.print(board2[i/board2[0].length][i%board2[0].length]);
		}
		
		My_Dictionary dict = new My_Dictionary();
		Set<String> my_dict = dict.getDictSet();	
		String[] array = my_dict.toArray(new String[0]);
		String[] array2 = {"oath","pea","eat","rain"};
		List<String> res = test2.findWords(board2, array);		
		System.out.println("\n" + res);	
	

	}

}
