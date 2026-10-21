class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentTank = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            totalSurplus += net;
            currentTank += net;

            // If we run out of gas, no station from startStation to i can be the answer.
            // Try starting fresh from station i + 1.
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }

        return totalSurplus >= 0 ? startStation : -1;
    }
}
