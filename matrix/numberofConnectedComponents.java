package matrix;

public class numberofConnectedComponents {
	
	public int countComponents(int n, int[][] edges) {
		if(edges == null || edges.length == 0 || n < 0) return 0;
		
		int ans = n;  // initilize to the max connected edges (no connection at all)
		int[] root = new int[n];
		
		for(int i = 0; i < n; i++) root[i] = i;
		
		for(int i = 0; i < edges.length; i++) {
			int from = edges[i][0];
			int to = edges[i][1];
			
			int from_root = getRoot(root, from);
			int to_root = getRoot(root, to);
			
			if(from_root != to_root) {
				root[from_root] = to_root;
				ans--;
			}
		}
			
		return ans;		
	}
	
	// like the pointer
	private int getRoot(int[] union, int idx){
		while(idx != union[idx]) idx = union[union[idx]];
		return idx;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		numberofConnectedComponents test = new numberofConnectedComponents();
		int n = 5;
		int[][] edges = {{0,1}, {1,2}, {3,4}};
		int[][] edges2 = {{0,1}, {1,2}, {2,3}, {3,4}};
		int ans = test.countComponents(n, edges);
		System.out.println(ans);
		ans = test.countComponents(n, edges2);
		System.out.println(ans);

	}

}
