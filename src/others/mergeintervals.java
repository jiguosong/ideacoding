package others;

import java.util.*;

class interval{
	int start;
	int end;
	interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class mergeintervals {
	public List<interval> findMergedRanges(interval[] in) {
		List<interval> res = new ArrayList<interval>();
		if (in == null || in.length == 0) return res;
		
		Arrays.sort(in, new Comparator<interval>(){
			public int compare(interval a, interval b){
				return a.start - b.start;   // if a.start > b.start, then do the sort -> smaller a.start is in the front
			}
		});
		
		interval prev = in[0];
		for (int i = 1 ; i < in.length ; i++) {
			interval curr = in[i];
			if (curr.start > prev.end) {
				res.add(prev);
				prev = curr;
			} else {
				interval tmp = new interval(prev.start, Math.max(prev.end, curr.end));
				prev = tmp;
			}
		}

	    res.add(prev);
		
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mergeintervals test = new mergeintervals();
		
		interval i1 = new interval(0,8);
		interval i2 = new interval(2,3);
		interval i3 = new interval(2,15);
		interval i4 = new interval(18,50);
		
		interval[] intervals = {i1, i2, i3, i4};

		List<interval> ans = test.findMergedRanges(intervals);
		Iterator<interval> it = ans.iterator();
		while(it.hasNext()) {
			interval tmp = it.next();
			System.out.print(tmp.start + " ");
			System.out.println(tmp.end);
		}
		

	}

}

