package heap;

import java.util.*;

class Edge {
	int x;
	int y;
	boolean isLeft;
	
	Edge(int x, int y, boolean isLeft) {
		this.x = x;
		this.y = y;
		this.isLeft = isLeft;
	}
}


class compareEdge implements Comparator<Edge> {
	public int compare(Edge a, Edge b) {
		if(a.x != b.x) return Integer.compare(a.x, b.x);
		if(a.isLeft && b.isLeft) return Integer.compare(b.y, a.y);
		if(!a.isLeft && !b.isLeft) return Integer.compare(a.y, b.y);
		return a.isLeft ? -1:1; 
	}
}

public class skyline {
	public List<int[]> getSkyline(int[][] buildings) {
		if(buildings == null || buildings.length == 0) return null;
		
		List<int[]> res = new ArrayList<int[]>();
		List<Edge> edges = new ArrayList<Edge>();
		
		for(int[] e:buildings){
			edges.add(new Edge(e[0], e[2], true));   // left
			edges.add(new Edge(e[1], e[2], false));  // right
		}
		
		Collections.sort(edges, new compareEdge());
		
		Queue<Integer> heightQeue = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		for(Edge e:edges){
			if(e.isLeft) {
				if(heightQeue.isEmpty() || e.y > heightQeue.peek()) res.add(new int[] {e.x, e.y});
				heightQeue.add(e.y);
			} else {
				heightQeue.remove(e.y);				
				if(heightQeue.isEmpty()) res.add(new int[] {e.x, 0});
				else if(e.y > heightQeue.peek()) res.add(new int[] {e.x, e.y});
			}
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		skyline test = new skyline();
		
		int[][]buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
		List<int[]> ans = test.getSkyline(buildings);
		
		Iterator<int[]> it = ans.iterator();
		while(it.hasNext()) {
			int[] tmp = it.next();
			System.out.println(Arrays.toString(tmp));
		}

	}

}
