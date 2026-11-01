class Solution {
public int orangesRotting(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int fresh = 0;
    int minutes = 0;
    // Find all rotten and fresh fruits
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 2) {
                queue.offer(new int[]{i, j});
            } 
            else if (grid[i][j] == 1) {
                fresh++;
            }
        }
    }
    int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    // Multi-source BFS
    while (!queue.isEmpty() && fresh > 0) {
        int size = queue.size();
        // Process one level = one minute
        for (int i = 0; i < size; i++) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                // Check boundaries and fresh fruit
                if (newRow < 0 || newCol < 0 ||
                    newRow >= m || newCol >= n ||
                    grid[newRow][newCol] != 1) {
                    continue;
                }
                // Make fresh fruit rotten
                grid[newRow][newCol] = 2;
                fresh--;
                queue.offer(new int[]{newRow, newCol});
            }
        }
        minutes++;
    }
    return fresh == 0 ? minutes : -1;
}

}