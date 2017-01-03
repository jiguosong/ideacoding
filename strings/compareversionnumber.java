package strings;

import java.util.*;

public class compareversionnumber {
	// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0
	public int compareVersion(String version1, String version2) {
		assert version1 != null;
		assert version2 != null;
		assert (version1.length() != 0 && version2.length() != 0);
		
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		int i = 0;
		while(i < v1.length || i < v2.length) {
			if (i < v1.length && i < v2.length) {
				if(Integer.valueOf(v1[i]) < Integer.valueOf(v2[i])) return -1;
				else if(Integer.valueOf(v1[i]) > Integer.valueOf(v2[i])) return 1;
			} else if(i < v1.length && Integer.valueOf(v1[i]) != 0) {
				return 1;
			} else if(i < v2.length && Integer.valueOf(v2[i]) != 0) {
				return -1;
			}
			i++;
		}
		
		return 0;		
	}

    public int compareVersion2(String version1, String version2) {
        assert version1 != null;
        assert version2 != null;
        version1 = version1.trim();
        version2 = version2.trim();
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int result = 0;
        int l1 = v1.length;
        int l2 = v2.length;
        for (int i = 0; i < Math.max(l1, l2); i++) {
            int a = ((l1 <= i) || v1[i].isEmpty()) ? 0 : Integer.valueOf(v1[i]);
            int b = ((l2 <= i) || v2[i].isEmpty()) ? 0 : Integer.valueOf(v2[i]);
            if (a > b) {
                result = 1;
                break;
            } else if (a < b) {
                result = -1;
                break;
            }
        }
        return result;
    }
	
	public int compareVersiontest(String version1, String version2) {
	    String[] arr1 = version1.split("\\.");
	    String[] arr2 = version2.split("\\.");
	 
	    int i=0;
	    while(i<arr1.length || i<arr2.length){
	        if(i<arr1.length && i<arr2.length){
	            if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
	                return -1;
	            }else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
	                return 1;
	            }
	        } else if(i<arr1.length){
	            if(Integer.parseInt(arr1[i]) != 0){
	                return 1;
	            }
	        } else if(i<arr2.length){
	           if(Integer.parseInt(arr2[i]) != 0){
	                return -1;
	            }
	        }
	 
	        i++;
	    }
	 
	    return 0;
	}
	
	
	// given isBadVersion(version), find the first bad version -- binary search
	public int firstBadVersion(int n) {
		int left = 1; 
		int right  = n;
		while(left < right) {
			int mid = left + (right-left)/2;
			if(isBadVersion(mid)) right = mid;
			else left = mid+1;
		}
		
		if(isBadVersion(left)) return left;
		else return right;
	}
	
	private boolean isBadVersion(int n){
		return true;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compareversionnumber test = new compareversionnumber();
		String version1 = "2.9";  // 1.07 is wrong???
		String version2 = "1.1";
		int ans = test.compareVersion(version1, version2);
		System.out.println(ans);

	}

}
