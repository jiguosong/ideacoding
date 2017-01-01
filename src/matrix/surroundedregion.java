package matrix;

import java.util.*;

public class surroundedregion {
	
    public void solve(char[][] board) {
    	if (board == null) return;
    	int row = board.length;
    	int col = board[0].length;
    	if (row == 0 || col == 0) return;
    	
    	for(int i = 0; i < col; i++) {
    		if (board[0][i] == 'O') bfs_helper(board, 0, i);
    	}

    	for(int i = 0; i < col; i++) {
    		if (board[row-1][i] == 'O') bfs_helper(board, row-1, i);
    	}

    	for(int i = 0; i < row; i++) {
    		if (board[i][0] == 'O') bfs_helper(board, i, 0);
    	}

    	for(int i = 0; i < row; i++) {
    		if (board[i][col-1] == 'O') bfs_helper(board, i, col-1);
    	}
    	
    	
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    			if (board[i][j] == 'O') board[i][j] = 'X';
    			if (board[i][j] == '1') board[i][j] = 'O';  // restore all 'a'
    		}
    	}
    }
    
    
    private void bfs_helper(char[][] board, int row, int col) {
    	if (board == null) return;
    	if (board[row][col] != 'O') return;
    	
    	int m = board.length;
    	int n = board[0].length;
    	
    	Deque<Integer> queue = new ArrayDeque<Integer>();
    	queue.add(row*m + col);
    	while(!queue.isEmpty()) {
    		Integer pos = queue.remove();
    		int x = pos/board[0].length;
    		int y = pos%board[0].length;  
    		board[x][y] = '1';
    		if (x < m-1 && board[x+1][y] == 'O') queue.add((x+1)*m+y);    			
    		if (x >= 1 && board[x-1][y] == 'O') queue.add((x-1)*m+y);
    		if (y < n-1 && board[x][y+1] == 'O') queue.add(x*m+y+1);
    		if (y >= 1 && board[x][y-1] == 'O') queue.add(x*m+y-1);
    	}    	
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		surroundedregion test = new surroundedregion();
		char[][] board = new char[4][4];
		board[0][0] = 'X';
		board[0][1] = 'X';
		board[0][2] = 'X';
		board[0][3] = 'X';
		
		board[1][0] = 'X';
		board[1][1] = 'O';
		board[1][2] = 'O';
		board[1][3] = 'X';
		
		board[2][0] = 'X';
		board[2][1] = 'X';
		board[2][2] = 'O';
		board[2][3] = 'X';
		
		board[3][0] = 'X';
		board[3][1] = 'O';
		board[3][2] = 'X';
		board[3][3] = 'X';
		
		for (int row = 0; row < board.length; row++) {
		    for (int col = 0; col < board[row].length; col++) {
		       System.out.print(board[row][col]); 
		    }
		    System.out.println();
		 }
		
		test.solve(board);

    	System.out.println();
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board.length; j++) {
    			System.out.print(board[i][j]);
    		}
    		System.out.println();
    	}

	}

}
