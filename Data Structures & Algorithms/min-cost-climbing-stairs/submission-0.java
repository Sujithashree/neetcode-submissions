class Solution {
public int minCostClimbingStairs(int[] cost) {
int n = cost.length;

    int first = 0;
    int second = 0;
    for (int i = 2; i <= n; i++) {
        int current = Math.min(
            second + cost[i - 1],
            first + cost[i - 2]
        );
        first = second;
        second = current;
    }
    return second;
}

}