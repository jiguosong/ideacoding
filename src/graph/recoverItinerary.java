package graph;

import java.util.*;

public class recoverItinerary {

	public List<String> findItinerary(String[][] tickets) {
		if (tickets == null || tickets.length == 0) return null;
		List<String> res = new LinkedList<String>();
		
		Map<String, Queue<String>> map = new HashMap<String, Queue<String>>();
		
		for (int i = 0 ; i < tickets.length; i++) {
			String[] s = tickets[i];
			if (!map.containsKey(s[0])) {
				Queue<String> queue = new PriorityQueue<String>();
				map.put(s[0], queue);
			}
			map.get(s[0]).offer(s[1]);			
		}
		
		findItinerary_helper("JFK", map, res);		
	
		return res;
	}
	
	private void findItinerary_helper(String s, Map<String, Queue<String>> map, List<String> res) {
		if (map == null || s == null) return;
		
		Queue<String> queue = map.get(s);
		while (queue != null && !queue.isEmpty()) {
			String curr_s = queue.poll();
			findItinerary_helper(curr_s, map, res);
		}
		
		res.add(0, s);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		recoverItinerary test = new recoverItinerary();
		String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};	
		String[][] tickets2 = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		List<String> ans = test.findItinerary(tickets);
		
		System.out.println(ans);

	}

}
