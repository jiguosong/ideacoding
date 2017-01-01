package math;

import java.util.*;


// basically it is alll about reservior sampling algorithm

// Min + (int)(Math.random() * ((Max - Min) + 1))
// or use Random

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class random {
	// Linked List Random Node
	public int getRandom(ListNode head) {
		if(head == null) return 0;
		
		ListNode res = null;
		ListNode curr = head;
		Random randomGenerator = new Random();
		
		int i = 1;
		while(curr != null) {
			if(randomGenerator.nextInt(i) == 0) res = curr;
			curr = curr.next;	
			i++;
		}
		
		return res.val;
	}
	
	// Shuffle a set of numbers without duplicates
	public static int[] RandomizeArray(int[] array){
		if(array == null || array.length == 0) return null;
		
		int sz = array.length;
		int[] res = new int[array.length];
		res = Arrays.copyOf(array, array.length);
		Random randomGenerator = new Random();
		
		for(int i = 0; i < sz; i++) {
			int idx = randomGenerator.nextInt(sz);
			int tmp = res[i];
			res[i] = res[idx];
			res[idx] = tmp;
		}
		
		return res;
	}
	
	// Given an array of integers with possible duplicates, randomly output the index of a given target number
	public int pick(int[] nums, int target) {
		 if(nums == null || nums.length == 0) return -1;
		 
		 Random randomGenerator = new Random();
		 
		 int cnt = 0;
		 int res = -1;
		 for(int i = 0; i < nums.length; i++) {
			 if(nums[i] != target) continue;
			 cnt++;
			 if(randomGenerator.nextInt(cnt) == 0) res = i;
		 }
		 
		 return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		random test = new random();
		
		int[] data = {1,2,3,4,5,6,7,8,9};
		MyList ll = new MyList(data);
		ll.PrintListAll();
		ListNode head = ll.getHead();
				
		System.out.println();
		int ans = test.getRandom(head);
		System.out.println(ans);

		System.out.println();
		int[] shuffle_array = test.RandomizeArray(data);
		for(int i=0; i<shuffle_array.length; i++) System.out.print(shuffle_array[i] + " ");
		System.out.println();
		for(int i=0; i<data.length; i++) System.out.print(data[i] + " ");
		
		System.out.println();
		int target = 3;
		int[] nums = new int[] {1,2,3,3,3};
		int idx = test.pick(nums, target);
		System.out.println(idx);
	}

}
