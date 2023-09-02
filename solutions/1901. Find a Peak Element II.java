class Solution {
​
    public int[] findPeakGrid(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
​
        for (int row = 0; row < R; row++) {
            int startCol = 0;
            int endCol = C - 1;
​
            while (startCol <= endCol) {
                int midColumn = startCol + (endCol - startCol) / 2;
                int element = grid[row][midColumn];
                int left = 1, right = 1, top = 1, bottom = 1;
                if (midColumn - 1 > 0) {
                    left = grid[row][midColumn - 1];
                }
                if (midColumn + 1 < C) {
                    right = grid[row][midColumn + 1];
                }
                if (row - 1 > 0) {
                    top = grid[row - 1][midColumn];
                }
                if (row + 1 < R) {
                    top = grid[row + 1][midColumn];
                }
​
                if (element > left && element > right && element > top && element > bottom) {
                    return new int[] { row, midColumn };
                }
​
                if (Math.max(left, grid[row][0]) < Math.max(right, grid[row][C - 1])) {
                    startCol = midColumn + 1;
                } else {
                    endCol = midColumn - 1;
                }
            }
        }
​
        return null;
    }
}
