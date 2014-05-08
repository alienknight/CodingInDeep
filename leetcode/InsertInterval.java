import java.util.*;

public class InsertInterval {
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Interval> res = new ArrayList<Interval> ();
        int i=0;
        int len = intervals.size();
        while(i<len && newInterval.start > intervals.get(i).end)
            res.add(intervals.get(i++));
        while(i<len && newInterval.end >= intervals.get(i).start) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            ++i;
        }
        res.add(newInterval);
        while(i<len)
            res.add(intervals.get(i++));
        return res;
    }
}

