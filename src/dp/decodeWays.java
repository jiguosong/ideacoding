package dp;

public class decodeWays {
	
	public int numDecodings(String s) {
		if(s == null || s.length() == 0) return 0;
		
		int start = 0;
		while(s.charAt(start) == '0') start++;
		if(s.substring(start).length() == 1) return 1;
		
		int n = s.substring(start).length();
		int[] ways = new int[n];
		ways[0] = 1;
		
		if(Integer.parseInt(s.substring(start, start+2)) > 26) {
			if(s.charAt(start+1) != '0') ways[1] = 1;
			else ways[1] = 0;   // '30, 40..' can not be decoded
		} else {
			if(s.charAt(start+1) != '0') ways[1] = 2;   
			else ways[1] = 1;  // what about "10"? -> can not be decoded
		}
		
		for(int i = start+2; i < s.length(); i++) {
			if(s.charAt(start) != '0') ways[i] += ways[i-1];

			int val = Integer.parseInt(s.substring(i-1, i+1));
			if(val <= 26 && val >= 10) ways[i] += ways[i-2];
		}	
		
		return ways[n-1];		
	}

	
	public int numDecodings_test(String s) {
	    if(s==null || s.length()==0 || s.charAt(0)=='0')
	        return 0;
	    if(s.length()==1)
	        return 1;
	 
	    int[] dp = new int[s.length()];    
	    dp[0]=1;
	    if(Integer.parseInt(s.substring(0,2))>26){
	        if(s.charAt(1)!='0'){
	            dp[1]=1;
	        }else{
	            dp[1]=0;
	        }
	    }else{
	        if(s.charAt(1)!='0'){
	            dp[1]=2;
	        }else{
	            dp[1]=1;
	        }
	    }
	 
	    for(int i=2; i<s.length(); i++){
	        if(s.charAt(i)!='0'){
	            dp[i]+=dp[i-1];
	        }
	 
	        int val = Integer.parseInt(s.substring(i-1, i+1));
	        if(val<=26 && val >=10){
	            dp[i]+=dp[i-2];
	        }
	    }
	 
	    return dp[s.length()-1];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		decodeWays test = new decodeWays();
		String s = "123";
		int ans = test.numDecodings(s);
		System.out.println(ans);
	}

}
