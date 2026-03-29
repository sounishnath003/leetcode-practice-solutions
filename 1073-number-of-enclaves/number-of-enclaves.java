class Solution {
    public int numEnclaves(int[][] grid) {
        return new M().numberOfEnclaves(grid);
    }

    class M {

        int R, C;

        public int numberOfEnclaves(int[][] grid) {
            R = grid.length;
            C = grid[0].length;
            // find the boundary cell with 1 and mark them with 2
            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    if (isBoundary(row, col) && grid[row][col] == 1) {
                        dfs(grid, row, col);
                    }
                }
            }

            int enclave = 0;
            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    if (grid[row][col] == 1) {
                        enclave += 1;
                    }
                }
            }

            return enclave;
        }

        private boolean isBoundary(int row, int col) {
            return (row == 0 || row == R - 1 || col == 0 || col == C - 1);
        }

        private void dfs(int[][] grid, int row, int col) {
            grid[row][col] = 2;

            int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
            for (int[] dir : dirs) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                if (isSafe(nrow, ncol) && grid[nrow][ncol] == 1) {
                    dfs(grid, nrow, ncol);
                }
            }
        }

        private boolean isSafe(int row, int col) {
            return (0 <= row && row < R && 0 <= col && col < C);
        }
    }

}