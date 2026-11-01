class Solution {
public void islandsAndTreasure(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    // Add all treasure chests to the queue
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 0) {
                queue.offer(new int[]{i, j});
            }
        }
    }
    // Four possible directions
    int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    // Multi-source BFS
    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int row = current[0];
        int col = current[1];
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // Check boundaries and whether the cell is land
            if (newRow < 0 || newCol < 0 ||
                newRow >= m || newCol >= n ||
                grid[newRow][newCol] != Integer.MAX_VALUE) {
                continue;
            }
            // Update distance
            grid[newRow][newCol] = grid[row][col] + 1;
            // Add updated cell to queue
            queue.offer(new int[]{newRow, newCol});
        }
    }
}

}