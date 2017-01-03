package others;

import java.util.*;

// this is like compute 24 game

public class gettargetnumListArithmetic {
	
	public boolean isReachable(ArrayList<Integer> list, int target) {
		if(list == null || list.size() == 0) return false;
		
		List<Integer> res = new ArrayList<Integer>();
		
		res = isReachable_helper(list, 0, list.size()-1, target);
		
		for(Integer e : res) {
			if(e == target) return true;
		}
		
		return false;
	}
	
	private List<Integer> isReachable_helper(ArrayList<Integer> list, int left, int right, int target) {
		List<Integer> tmp = new ArrayList<Integer>();
		if(left > right) return tmp;
		if(left == right) {
			tmp.add(list.get(left));   // if the list[left] is the target, we do not need do any calculation
			return tmp;
		}
		
		for(int i = left; i < right; i++) {
			List<Integer> left_res = isReachable_helper(list, left, i, target);
			List<Integer> right_res = isReachable_helper(list, i+1, right, target);
			
			for(int x : left_res){
				for(int y : right_res){
					tmp.add(x+y);
					tmp.add(x-y);
					tmp.add(x*y);
					if(y!=0)tmp.add(x/y);
				}
			}
		}
		
		return tmp;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		gettargetnumListArithmetic test = new gettargetnumListArithmetic();

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		int target = 24;
		if(test.isReachable(list, target)) System.out.println("Found one");
		else System.out.println("No!");
		
		

	}

}
