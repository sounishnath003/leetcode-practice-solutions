class Solution {
     public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
       int c = matrix[0].length - 1;
       while(r < matrix.length && c >= 0) {
           if (matrix[r][c] == target)
            return true;
           else if (matrix[r][c] > target) c--;
           else r++;
       }
        return false;
    }
​
    private boolean searchElem(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi) {
            int mid = (lo+hi) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target)
                lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
