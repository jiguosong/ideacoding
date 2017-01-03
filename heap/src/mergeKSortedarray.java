package heap.src;

import java.util.*;

class ArrayContainer implements Comparable<ArrayContainer> {
	int[] array;
	int index;
	
	public ArrayContainer(int[] array, int index)  {
		this.array = array;
		this.index = index;
	}
	
	@Override
	public int compareTo(ArrayContainer o) {
		return this.array[this.index] - o.array[o.index];
	}
}

public class mergeKSortedarray {
	
	public static int[] mergeKSortedArray(int[][] arr) {
		if (arr == null) return null;
		int row = arr.length;
		int col = arr[0].length;
		if (row == 0 || col == 0) return null;

		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		
		int total_size = 0;
		for (int i = 0; i < row; i++) {
			ArrayContainer tmp = new ArrayContainer(arr[i], 0);
			queue.add(tmp);
			total_size += arr[i].length;
		}
		int[] res = new int[total_size];		
		int idx = 0;
		
		while(!queue.isEmpty()) {
			ArrayContainer tmp_array = queue.poll();
			res[idx++] = tmp_array.array[tmp_array.index];
			if (tmp_array.index < tmp_array.array.length - 1) {
				ArrayContainer k = new ArrayContainer(tmp_array.array, tmp_array.index+1);
				queue.add(k);
			}			
		}
		
		return res;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mergeKSortedarray test = new mergeKSortedarray();
		
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
		
		int[][] arr = {arr1, arr2, arr3};
 
		int[] result = test.mergeKSortedArray(arr);
		System.out.println(Arrays.toString(result));
	}

}
