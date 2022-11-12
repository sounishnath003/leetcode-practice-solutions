class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return find(matrix, target);
    }
    private boolean find(int[][] grid, int target) {
        int R = grid.length;
        int C = grid[0].length;
​
        int lo = 0;
        int hi = (R * C) - 1;
​
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int irow = mid / C;
            int icol = mid % C;
            int value = grid[irow][icol];
​
            if (value == target)
                return true;
            else if (value < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
​
        return false;
    }
}
