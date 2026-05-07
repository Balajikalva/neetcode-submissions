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
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals.size() == 0) return 0;

        Collections.sort(intervals, (a, b) -> {

            if (a.start == b.start) {
                return b.end - a.end;
            }

            return a.start - b.start;
        });

        List<Interval> days = new ArrayList<>();

        for (int i = 0;i < intervals.size(); i++) {

            Interval interval = intervals.get(i);
            boolean isAdded = false;

            for (Interval curr : days) {

                if (curr.end <= interval.start) {

                    curr.end = interval.end;
                    isAdded = true;
                    break;
                }
            }

            if (!isAdded) {
                days.add(interval);
            }
            
        }

        return days.size();
    }
}
