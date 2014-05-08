import java.util.*;

public class MergeInterval {
	public static class Interval {                                      //Optimal
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	 }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(intervals==null || intervals.size()==0) return intervals;
        Collections.sort(intervals,new Comparator<Interval>() {
           public int compare(Interval v1, Interval v2) {
               if(v1.start<v2.start) return -1;
               else if(v1.start>v2.start) return 1;
               else return 0;
           } 
        });
        for(int i=1;i<intervals.size();i++) {
            if(intervals.get(i).start<=intervals.get(i-1).end) {
                intervals.get(i-1).end = Math.max(intervals.get(i-1).end, intervals.get(i).end);
                intervals.remove(i);
                --i;
            }
        }
        return intervals;
    }
}

