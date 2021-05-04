class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
         * STEP 1: Find potential Row
         * STEP 2: Find pos of Target  
         */
​
        int potentialRow = findPotentialRow(matrix, target);
        if (potentialRow == -1) return false ;
        boolean isFound = findTarget(matrix[potentialRow], target);
        return isFound ;
    }
    private int findPotentialRow(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;
        int C = matrix[0].length - 1;
​
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][C]) return mid;
            else if (matrix[mid][0] > target) hi = mid - 1;
            else if (matrix[mid][0] < target) lo = mid + 1;
        }
        return -1;
    }
​
    private boolean findTarget(int[] matrix , int target) {
        int lo = 0;
        int hi = matrix.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (matrix[mid] == target) return true;
            else if (matrix[mid] > target) hi = mid - 1;
            else if (matrix[mid] < target) lo = mid + 1;
        }
        return false;
    }
}
