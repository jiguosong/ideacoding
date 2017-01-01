package others; // this is not done yet

public class equilibrium {

	 public int solution(int[] A) {
		 if (A == null || A.length == 0) return -1;
		 int ret = -1;
		 
		 int[] sum = new int[A.length+1];
		 sum[0] = A[0];
		 System.out.print(sum[0] + " ");
		 for (int i = 1; i < A.length; i++) {
			 sum[i] = sum[i-1] + A[i];
			 System.out.print(sum[i] + " ");
		 }
		 System.out.println();
		 sum[A.length] = sum[A.length-1];
		 
		 //if (sum[A.length] - sum[0] == 0) return 0;  // -1 index means 0
		 //if (sum[A.length] == sum[A.length-2]) return A.length-1;  // -1 index means 0
		 
		 System.out.println("kk");
		 for (int i = 0; i < sum.length; i++) {
			 int k = sum[A.length] - sum[i];
			 if (i > 0) {
				 if (sum[i-1] == k) {
					 ret = i;
					 System.out.println(ret);
				 }
			 } else {
				 if (0 == k) {
					 ret = i;
					 System.out.println(ret);
				 }
			 }
		 }		 
		 
		 return ret;
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] in =  {-1, 3, -4, 5, 1, -6, 2, 1};
		equilibrium test = new equilibrium();
		int res = test.solution(in);
		
		for (int i = 0; i < in.length; i++) {
			System.out.print(in[i] + " ");
		}
		
		System.out.println();
		System.out.println(res);
		
		
		
	}

}
