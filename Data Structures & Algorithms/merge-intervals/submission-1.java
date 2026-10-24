

class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. Sort intervals by start time in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        
        // Start with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // 2. Iterate through the intervals and merge overlaps
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlapping intervals: extend the end of currentInterval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Non-overlapping interval: add it to the list and update currentInterval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
