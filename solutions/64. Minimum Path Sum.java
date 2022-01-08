class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;

        int R = grid.length;
        int C = grid[0].length;

        for (int col = 1; col < C; col++) {
            grid[0][col] += grid[0][col - 1];
        }

        for (int row = 1; row < R; row++) {
            grid[row][0] += grid[row - 1][0];
        }

        for (int row = 1; row < R; row++) {
            for (int col = 1; col < C; col++) {
                if (row - 1 < 0 || col - 1 < 0)
                    continue;
                int cost = getCost(grid, row, col);
                grid[row][col] = cost;
            }
        }

        return grid[R - 1][C - 1];
    }

    private int getCost(int[][] grid, int row, int col) {
        return Math.min(grid[row - 1][col], grid[row][col - 1]) + grid[row][col];
    }
}
