class Solution {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        
        boolean isColumnZero = checkColIfZero(matrix, R, C);
        boolean isRowZero = checkRowIfZero(matrix, R, C);
        
        for (int row = 1; row < R; row++) {
            for (int col = 1; col < C; col++) {
                int elem = matrix[row][col];
                if (elem == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        
        for (int col = 1; col < C; col++) {
            if (matrix[0][col]==0) {
                for (int row = 0; row < R; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        
        for (int row = 1; row < R; row++) {
            if (matrix[row][0]==0) {
                for (int col = 0; col < C; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        if (isColumnZero) {
            for (int row = 0 ; row < R; row++) {
                matrix[row][0] = 0;
            }
        }
        
        if (isRowZero) {
            for (int col = 0; col < C; col++) {
                matrix[0][col] = 0;
            }
        }
    }
​
    private boolean checkRowIfZero(int[][] matrix, int r, int c) {
        // TODO Auto-generated method stub
        for (int col = 0; col < c; col++)
            if (matrix[0][col] == 0) return true;
        
        return false;
    }
​
    private boolean checkColIfZero(int[][] matrix, int r, int c) {
        // TODO Auto-generated method stub
        for (int row = 0; row < r; row++)
            if (matrix[row][0]==0) return true;
        
        return false;
    }
}
