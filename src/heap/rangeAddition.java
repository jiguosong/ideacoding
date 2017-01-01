package heap;

import java.util.Arrays;

public class rangeAddition {

	// this is not using any heap at all. For [start, end, val], just add val to the start and -val to the end+1 element. Finally add up.
	public int[] getModifiedArray(int length, int[][] updates) {
	    int[] result = new int[length];
	    if(updates==null||updates.length==0)
	        return result;
	 
	    for(int i=0; i<updates.length; i++){
	        result[updates[i][0]] += updates[i][2];
	        if(updates[i][1]<length-1){
	            result[updates[i][1]+1] -=updates[i][2];
	        }
	        System.out.println(Arrays.toString(result));
	        
	    }
	 
	    int v=0;
	    for(int i=0; i<length; i++){
	        v += result[i];
	        result[i]=v;	  
	    }
	 
	    return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		rangeAddition test = new rangeAddition();
		int[][] updates = {{1,  3,  2}, {2,  4,  3}, {0,  2, -2}};
		int length = 5;
		int[] ans = test.getModifiedArray(length, updates);
		System.out.println(Arrays.toString(ans));
		

	}

}
