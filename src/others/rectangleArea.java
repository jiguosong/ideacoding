package others;

public class rectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int total_area = 0;
		
		int area = Math.abs(A-C)*Math.abs(B-D) + Math.abs(E-G)*Math.abs(F-H);
		
		if(C < E || G < A) return area;
		if(H < B || D < F) return area;
		
		int right = Math.min(C, G);
		int left = Math.max(E, A);
		int top = Math.min(D, H);
		int bottom = Math.min(B, F);
		total_area = area - Math.abs(left-right)*Math.abs(top-bottom);
		return total_area;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		rectangleArea test = new rectangleArea();
		int ans = test.computeArea(1, 2, 3, 4, 5, 6, 7, 8);
		System.out.println(ans);

	}

}
