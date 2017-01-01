package heap;

import java.util.*;

class Interval{
	int start,end;
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class meetingRoom {
	
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) return false;
		Arrays.sort(intervals, 
			new Comparator<Interval>() {
				public int compare(Interval a, Interval b) {
					return a.start - b.start;
					//return a.end - b.end;
				}
			}
		);
		
		for (int i = 0; i < intervals.length-1; i++) {
			if (intervals[i].end > intervals[i+1].start) return false;
		}		
		
		return true;
	}
	
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) return 0;
		int res = 1;
		
		Arrays.sort(intervals, 
			new Comparator<Interval>() {
				public int compare(Interval a, Interval b) {
					return a.start - b.start;
				}
			}
		);
		
		Queue<Integer> prioQueue = new PriorityQueue<Integer>();
		prioQueue.offer(intervals[0].end);
		
		for(int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < prioQueue.peek()) {
				res++;
			} else {
				prioQueue.poll();
			}
			
			prioQueue.offer(intervals[i].end);
		}
		
		return res;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		meetingRoom test = new meetingRoom();
		Interval i1 = new Interval(0,8);
		Interval i2 = new Interval(2,3);
		Interval i3 = new Interval(1,10);
		Interval i4 = new Interval(8,50);
		
		Interval[] intervals = {i1, i2, i3, i4};

		if (test.canAttendMeetings(intervals)) System.out.println("Yes");
		else System.out.println("No");
		
		int rooms = test.minMeetingRooms(intervals);
		System.out.println(rooms);;
	}

}
