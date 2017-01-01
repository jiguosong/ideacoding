package others;

import java.util.Arrays;

public class mergeSortedArray {
	
	 public void merge(int A[], int m, int B[], int n) {
		 if (m == 0 || n == 0 || A.length == 0 || B.length == 0) return;
		 
		 while(m > 0 && n > 0) {
			 if (A[m-1] > B[n-1]) {
				 A[m+n-1] = A[m-1];
				 m--;
			 } else {
				 A[m+n-1] = B[n-1];
				 n--;
			 }
		 }
		 
		 while(n > 0) {
			 A[m+n-1] = B[n-1];
			 n--;
		 }
	 }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mergeSortedArray test = new mergeSortedArray();
		
		int[] A = new int[10];
		A[0] = 1;
		A[1] = 5;
		A[2] = 10;
		int[] B = {2,4,7};
		int m = 3;
		int n = 3;
		
		test.merge(A, m, B, n);

		System.out.println(Arrays.toString(A));
	}

}
