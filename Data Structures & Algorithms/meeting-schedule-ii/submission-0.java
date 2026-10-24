

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) return 0;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int endPtr = 0;

        for (int startPtr = 0; startPtr < n; startPtr++) {
            // If a meeting starts before the earliest ongoing meeting ends, we need a new room
            if (starts[startPtr] < ends[endPtr]) {
                rooms++;
            } else {
                // Otherwise, a previous meeting has ended and we reuse its room
                endPtr++;
            }
        }

        return rooms;
    }
}
