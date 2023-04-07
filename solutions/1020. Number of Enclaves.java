​
        // TOP BOUNDARY & BOTTOM BOUNDARY
        for (int col = 0; col < C; col++) {
            // only 1st and last col check for land
            if (!isWater(grid[0][col]))
                checkIfFormsAnIsland(grid, 0, col);
            if (!isWater(grid[R - 1][col]))
                checkIfFormsAnIsland(grid, R - 1, col);
        }
​
        // now only count for no. of 1s
        for (int row = 1; row < R; row++) {
            for (int col = 1; col < C; col++)
                if (!isWater(grid[row][col]))
                    enclaves++;
        }
        return enclaves;
​
    }
​
    private void checkIfFormsAnIsland(int[][] grid, int row, int col) {
        int R = grid.length;
        int C = grid[0].length;
​
        int[] dx = new int[] { 0, -1, 0, 1 };
        int[] dy = new int[] { -1, 0, 1, 0 };
​
        grid[row][col] = 0;
​
        for (int k = 0; k < dx.length; k++) {
            int nrow = row + dx[k];
            int ncol = col + dy[k];
            if (nrow >= 0 && ncol >= 0 && nrow < R && ncol < C && !isWater(grid[nrow][ncol])) {
                checkIfFormsAnIsland(grid, nrow, ncol);
            }
        }
    }
}
​
