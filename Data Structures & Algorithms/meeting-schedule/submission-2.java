/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for (int i = 0;i < intervals.size() - 1; i++) {

            Interval curr = intervals.get(i);
            Interval next = intervals.get(i + 1);      

            if (next.start < curr.end) {

                return false;
            }      
        }

        return true;
    }
}
