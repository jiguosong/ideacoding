package others;

import java.util.*;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class insertinterval {
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		if(intervals == null || intervals.size() == 0) return null;
		if(newInterval == null) return intervals;
		ArrayList<Interval> res = new ArrayList<Interval>();
		
		// Every time when compare, we know there is some interval added or updated. Some merger might be necessary
		for(Interval e:intervals) {
			if(e.end < newInterval.start) {
				res.add(e);
			} else if(newInterval.end < e.start) {   // similar to the curr and prev style once we get here
				res.add(newInterval);
				newInterval = e;
			} else if(newInterval.end >= e.start || e.end >= newInterval.start) {   // do not add to the res when merging
				newInterval = new Interval(Math.min(e.start, newInterval.start), Math.max(e.end, newInterval.end));
			}
		}

		res.add(newInterval);
		
		return res;	
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		insertinterval test = new insertinterval();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
			
		Interval newInterval = new Interval(4,9);
		ArrayList<Interval> ans = test.insert(intervals, newInterval);
		Iterator<Interval> it = ans.iterator();
		while(it.hasNext()) {
			Interval tmp = it.next();
			System.out.print(tmp.start + " " + tmp.end + "\n");
		}
		
		 
	}

}
