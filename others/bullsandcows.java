package others;

public class bullsandcows {

	public String getHint(String secret, String guess) {
		if(secret == null || secret.length() == 0) return null;
		if(guess == null || guess.length() == 0) return null;
		
		int bulls = 0;
		int cows = 0;
		
		int[] sarray = new int[10];
		int[] garray = new int[10];
		
		for(int i = 0; i < secret.length(); i++) {
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if(s == g) bulls++;
			else{
				sarray[s-'0']++;
				garray[g-'0']++;
			}
		}
				
		for(int i = 0; i < 10; i++) {
			cows +=  Math.min(sarray[i], garray[i]);
		}
		
		return String.valueOf(bulls)+'A'+String.valueOf(cows)+'B';
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		bullsandcows test = new bullsandcows();
		String secret = "1807";
		String guess = "7819";
		String ans = test.getHint(secret, guess);
		System.out.println(ans);

	}

}
