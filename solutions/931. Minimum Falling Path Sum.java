public class Solution {
    private class Cell {
        int row;
        int col;
        int cost;
​
        public Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
​
        @Override
        public String toString() {
            return "Cell [row=" + row + ", col=" + col + ", cost=" + cost + "]";
        }
    }
​
    private int miniCost = Integer.MAX_VALUE;
​
    public int minFallingPathSum(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
​
        /*
         * dp[row][col] = matrix[row][col] + dp[row-1][col-1, col, col+1] until and
         * unless is in safe side
         */
​
        int[][] dp = new int[R][C];
        for (int col = 0; col < C; col++)
            dp[0][col] = matrix[0][col];
​
        for (int row = 1; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (isThatCell(col, 0)) {
                    dp[row][col] += Math.min(dp[row - 1][col], dp[row - 1][col + 1]) + matrix[row][col];
                } else if (isThatCell(col, C - 1)) {
                    dp[row][col] += Math.min(dp[row - 1][col], dp[row - 1][col - 1]) + matrix[row][col];
                } else {
                    dp[row][col] += Math.min(dp[row - 1][col - 1], Math.min(dp[row - 1][col], dp[row - 1][col + 1]))
                            + matrix[row][col];
                }
            }
        }
​
