package others;

import java.util.*;

class Numwrapper{
	int num;
	int cnt;
	
	Numwrapper(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}

class comparecnt implements Comparator<Numwrapper> {
	public int compare(Numwrapper a, Numwrapper b) {
		return a.cnt - b .cnt;
	}
}

public class topKelement {
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		  if(nums == null || nums.length == 0) return null;
		  List<Integer> res  = new ArrayList<Integer>();
		  
		  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		  for(int i:nums) {
			  if(map.containsKey(i)) map.put(i, map.get(i)+1);
			  else map.put(i, 1);
		  }
		  
		  PriorityQueue<Numwrapper> priorityqueue = new PriorityQueue<Numwrapper>(k+10, new comparecnt());
		  
		  for(Map.Entry<Integer, Integer> e: map.entrySet()) {
			  Numwrapper tmp = new Numwrapper(e.getKey(), e.getValue());
			  priorityqueue.offer(tmp);
			  if(priorityqueue.size() > k) priorityqueue.poll();
		  }
		  
		  while(!priorityqueue.isEmpty()) {
			  res.add(priorityqueue.poll().num);
		  }
		  
		  Collections.reverse(res);
		  
		  return res;
	}

	
	public List<Integer> topKFrequent_buket(int[] nums, int k) {
		  if(nums == null || nums.length == 0) return null;
		  List<Integer> res  = new ArrayList<Integer>();
		  
		  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		  for(int i:nums) {
			  if(map.containsKey(i)) map.put(i, map.get(i)+1);
			  else map.put(i, 1);
		  }
		  
		  int max_freq = 0;
		  for(Map.Entry<Integer, Integer> e: map.entrySet()) {
			  max_freq = Math.max(max_freq, e.getValue());
		  }
		  
		  /* List<List<Integer>> buckets2 = new ArrayList<List<Integer>>(max_freq+1);         // or another way is to use list
		  for(int i = 0; i < buckets2.size(); i++) buckets2.set(i, new ArrayList<Integer>()); */

		  ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[max_freq+1]; // you can create array of array list like this
		  for(int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<Integer>();		  
		  for(Map.Entry<Integer, Integer> e: map.entrySet()) {
			  int freq = e.getValue();
			  if(freq != 0) {
				  int num = e.getKey();
				  buckets[freq].add(num);
			  }
		  }
		  
		  for(int i = max_freq; i >= 1; i--) {
			  for(Integer e:buckets[i]) {
				  res.add(e);
				  if(res.size() == k) return res;
			  }
		  }
		  
		  return res;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		topKelement test = new topKelement();
		int[] nums = {1,1,1,2,2,3,3,3,3,4,5,6,6,6,6,6,6,6,6};
		int k = 2;
		List<Integer> ans = test.topKFrequent(nums, 2);		
		System.out.println(ans);
		
		ans = test.topKFrequent_buket(nums, 2);		
		System.out.println(ans);


	}

}
