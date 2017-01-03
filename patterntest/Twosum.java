package patterntest;

import java.util.*;

public class Twosum extends Sum{
	@Override
	protected void run() {
		System.out.println(super.getProblemType());
		Integer[] array = {10, 2, 3, 4, 5, 6};
		List<Integer> input = Arrays.asList(array);			
		int[] res = twoSum_map(input, 5);
		System.out.println(array[res[0]]);
		System.out.println(array[res[1]]);
		System.out.println();
	}
	
	public int[] twoSum_map(List<Integer> A, int sum)
	{
		if (A == null || A.size() == 0) return null;		
		int[] res = {-1, -1};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < A.size(); i++) {
			if (map.containsKey(A.get(i))) {
				int index = map.get(A.get(i));
				res[0] = index;
				res[1] = i;
				break;
			} else {
				map.put(sum - A.get(i), i);
			}			
		}	
		return res;
	}
	
	private Twosum(){
		super(Sumtype.twosum);
	}
	
	private static Twosum p = null;
	
	public static Twosum instance() {
		if(p == null) p = new Twosum();
		return p;
	}

}
