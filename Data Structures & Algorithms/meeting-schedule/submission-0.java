

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
        // 1. Sort meetings by start time in ascending order
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // 2. Check if any meeting starts before the previous one ends
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false; // Overlap detected
            }
        }

        return true; // No conflicts found
    }
}
