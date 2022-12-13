public class Solution {
    private class Cell {
        int row;
        int col;
        int cost;

        public Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Cell [row=" + row + ", col=" + col + ", cost=" + cost + "]";
        }
    }

    private int miniCost = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        /*
         * dp[row][col] = matrix[row][col] + dp[row-1][col-1, col, col+1] until and
         * unless is in safe side
         */

        int[][] dp = new int[R][C];
        for (int col = 0; col < C; col++)
            dp[0][col] = matrix[0][col];

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

        for (int[] row : dp) {
            // System.out.println(Arrays.toString(row));
        }

        return Arrays.stream(dp[R - 1]).min().getAsInt();
    }

    private boolean isThatCell(int col, int C) {
        return col == C;
    }

    public int minFallingPathSum2(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        for (int col = 0; col < C; col++) {
            Cell startCell = new Cell(0, col, matrix[0][col]);
            getTheCostForFallingPath(matrix, startCell);
        }
        return miniCost;
    }

    private void getTheCostForFallingPath(int[][] matrix, Cell cell) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[] dy = new int[] { -1, 0, +1 };

        for (int dir = 0; dir < dy.length; dir++) {
            int nextrow = cell.row + 1;
            int nextcol = cell.col + dy[dir];

            if (hasReached(new Cell(nextrow, nextcol, 0), R, C)) {
                miniCost = Math.min(miniCost, cell.cost);
                return;
            }

            if (!safeArea(nextrow, nextcol, R, C))
                continue;
            int newcost = cell.cost + matrix[nextrow][nextcol];
            Cell nextcell = new Cell(nextrow, nextcol, newcost);
            System.out.println("f=" + cell + " n=" + nextcell);
            getTheCostForFallingPath(matrix, nextcell);
        }

        return;
    }

    private boolean hasReached(Cell cell, int R, int C) {
        return (cell.row == R);
    }

    private boolean safeArea(int r, int c, int R, int C) {
        return (r >= 0 && r < R) && (c >= 0 && c < C);
    }
}
