package math;

import java.util.*;

public class pascaltriangle {
	
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		if(numRows <= 0) return null;
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> prev = new ArrayList<Integer>();
		
		prev.add(1);
		res.add(prev);
		
		for(int row = 1; row < numRows; row++) {
			int size = row + 1;
			ArrayList<Integer> curr = new ArrayList<Integer>();   // every time we need a new one, or we need create a new one 
			curr.add(0, 1);
			for(int i = 1; i < size-1; i++) {
				curr.add(i, prev.get(i-1)+prev.get(i));
			}
			curr.add(1);
			res.add(curr);
			prev = curr;
		}
		
		return res;
	}	
	
	public List<Integer> getRow(int rowIndex) {
		if(rowIndex <= 0) return null;
		
		List<Integer> res = new ArrayList<Integer>();
		
		res.add(1);		
		for(int row = 1; row < rowIndex; row++) {
			int sz = res.size();  // process for this size only
			// this needs to be done back-to-front, since we do not want to accumulate the old value
			for(int j = res.size()-1; j > 0; j--) {
				res.set(j, res.get(j-1) + res.get(j));
			}
			
			res.add(1);
		}
		
		return res;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		pascaltriangle test = new pascaltriangle();
		int numRows = 6;
		ArrayList<ArrayList<Integer>> ans = test.generate(numRows);
		Iterator<ArrayList<Integer>> it = ans.iterator();
		while(it.hasNext()) {
			ArrayList<Integer> tmp = it.next();
			System.out.println(tmp);
		}
		
		System.out.println();
		List<Integer> row = test.getRow(5);
		System.out.println(row);
	}

}
 