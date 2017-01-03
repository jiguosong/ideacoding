package math;

// Implement pow(x, n)

public class powers {
	
	public double power_short(double x, int n) {
		if (n == 0)	return 1;
	 
		double v = power_short(x, n / 2);
	 
		if (n % 2 == 0) return v * v;
		else return v * v * x;
	}
	
	public double power_recursive(double x, int n) {
		if(n == 0) return 1;
		if(n == 1) return x;
		
		if(x < 0 && n < 0 && n%2 == 1) return -1/(power_recursive(-x,n/2)*power_recursive(-x,n/2)*power_recursive(-x,n%2));
		else if(x > 0 && n < 0) return 1/(power_recursive(x,n/2)*power_recursive(x,n/2)*power_recursive(x,n%2));
		else return (power_recursive(x,n/2)*power_recursive(x,n/2)*power_recursive(x,n%2));
	}
	
	public boolean isPowerOfTwo(int n) {
		return (n > 0 && (n&(n-1)) == 0);
	}
	
	public boolean isPowerOfThree(int n) {
		if(n == 0) return false;
		if(n == 1) return true;
		
		if(n > 1) return (n%3 == 0 && isPowerOfThree(n/3));
		else return false;
	}
	
	public boolean isPowerOfFour(int n) {
		if(n == 0) return false;
		if(n == 1) return true;
		
		if(n > 1) return (n%4 == 0 && isPowerOfFour(n/4));
		else return false;
	}
	
	public boolean isPowerOfFour_itertative(int n) {
		if(n == 0) return false;
		
		while(n > 0) {	
			if(n == 1) return true;
			if(n%4 != 0) return false;
			n = n/4;
		}

		return true;	
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long startTime;
		long endTime;
		long totalTime;
		
		powers test = new powers();
		double ans;
		
		startTime = System.currentTimeMillis();
		ans = test.power_recursive(2,3);
		endTime   = System.currentTimeMillis();
		System.out.println(ans);
		totalTime = endTime - startTime;
		//System.out.println(totalTime);

		ans = test.power_short(2,3);
		System.out.println(ans);
		
		if(test.isPowerOfTwo(1024)) System.out.println("Yes pwoer of 2");
		else System.out.println("Not pwoer of 2");
		
		if(test.isPowerOfThree(27)) System.out.println("Yes pwoer of 3");
		else System.out.println("Not pwoer of 3");
		
		if(test.isPowerOfFour_itertative(256)) System.out.println("Yes pwoer of 4");
		else System.out.println("Not pwoer of 4");
	}

}
