

class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Traverse from top (Pacific) and bottom (Atlantic) borders
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, Integer.MIN_VALUE, pacific);
            dfs(heights, rows - 1, c, Integer.MIN_VALUE, atlantic);
        }

        // Traverse from left (Pacific) and right (Atlantic) borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, r, cols - 1, Integer.MIN_VALUE, atlantic);
        }

        // Collect cells reachable from both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, int prevHeight, boolean[][] visited) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length 
                || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        for (int[] dir : DIRS) {
            dfs(heights, r + dir[0], c + dir[1], heights[r][c], visited);
        }
    }
}
