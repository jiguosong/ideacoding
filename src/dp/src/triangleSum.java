package dp.src;

import java.util.*;

// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below
public class triangleSum {
	
	// bottom up
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) return 0;
		List<Integer> path = new ArrayList<Integer>(triangle.get(triangle.size()-1));
		
		for(int row = triangle.size() - 2; row >= 0; row--) {
			for (int col = 0; col < triangle.get(row+1).size()-1; col++) {
				int tmp = Math.min(path.get(col), path.get(col+1)) + triangle.get(row).get(col);
				path.set(col, tmp);
			}
		}
		
		return path.get(0);
	}
	
	// top down
	public int minimumTotal_topdown(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) return 0;
		
		for(int i = 1; i < triangle.size(); i++) {
			for(int j = 0; j < triangle.get(i).size(); j++) {
				if(j == 0) triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
				else if(j == triangle.get(i).size()-1) triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
				else triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
			}
		}
		
		int min = triangle.get(triangle.size()-1).get(0);
		for(int j = 1; j < triangle.get(triangle.size()-1).size(); j++) {
			min = Math.min(min, triangle.get(triangle.size()-1).get(j));
		}
		
		return min;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		triangleSum test = new triangleSum();
		
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();	
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);
		
		int ans = test.minimumTotal(triangle);
		System.out.println(ans);
		
		ans = test.minimumTotal_topdown(triangle);
		System.out.println(ans);

	}

}
