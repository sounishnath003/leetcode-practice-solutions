class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
​
        // check for upper right corners
        for(int col=0; col < C; col++) {
            boolean f = checkUpperDiagonal(matrix, col);
            if(!f) return false;
        }
​
        // check for lower left corners
        for(int row=0; row < R; row++) {
            boolean f = checkLowerDiagonal(matrix, row);
            if(!f) return false;
        }
​
        return true;
    }
​
    private boolean checkLowerDiagonal(int[][] matrix, int row) {
        // TODO Auto-generated method stub
        int R = matrix.length;
        int C = matrix[0].length;
​
        int felem=matrix[row][0];
        for(int col=0; row < R && col < C; row++, col++) {
            int selem=matrix[row][col];
            if(felem != selem) return false;
        }
​
        return true;
    }
​
    private boolean checkUpperDiagonal(int[][]matrix, int col) {
        // TODO Auto-generated method stub
        int R = matrix.length;
        int C = matrix[0].length;
​
        int felem=matrix[0][col];
        for(int row = 0; row < R && col < C; row++, col++) {
            int selem=matrix[row][col];
            if(felem!=selem) return false;
        }
​
        return true;
    }
}
