

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 1. Sort intervals by end time in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        // 2. Iterate through the remaining intervals and count overlaps
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart < prevEnd) {
                // Overlap detected: remove the current interval (which ends later or at the same time)
                removals++;
            } else {
                // No overlap: keep the current interval and update prevEnd
                prevEnd = currentEnd;
            }
        }

        return removals;
    }
}
