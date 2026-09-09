class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // Maximum pile is the upper bound for k
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int answer = right;

        while (left <= right) {
            int k = left + (right - left) / 2;

            long hours = 0;

            for (int pile : piles) {
                // Ceiling(pile / k)
                hours += (pile + (long) k - 1) / k;
            }

            if (hours <= h) {
                // k works, try a smaller speed
                answer = k;
                right = k - 1;
            } else {
                // k is too slow
                left = k + 1;
            }
        }

        return answer;
    }
}