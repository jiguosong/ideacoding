package others;

import java.util.*;

 // 2 sort conditions
public class reconstructqueue {
	
	// Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers(h, k), 
	// where h is the height of the person and k is the number of people in front of this person who have a height greater 
	// than or equal to h. Write an algorithm to reconstruct the queue.
	
	class mycompare implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2){
			 if (o1[0] > o2[0]) return -1;
	            else if (o1[0] < o2[0]) return 1;
	            else return o1[1] - o2[1];
		}
	}
	
	
	public int[][] reconstructQueue(int[][] people) {
		if(people == null || people.length == 0) return null;
		
		int m= people.length;
		int n= people[0].length;
		
		Arrays.sort(people, new mycompare());
		
		int[][] res = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				res[i][j] = people[i][j]; 
			}
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reconstructqueue test = new reconstructqueue();
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] res = test.reconstructQueue(people);
		
		int m = res.length;
		int n = res[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(res[i][j]); 
			}
			System.out.println();
		}
	}

}
