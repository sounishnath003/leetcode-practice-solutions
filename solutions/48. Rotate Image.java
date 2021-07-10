class Solution {
    public void rotate(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
​
        // find tranpose of matrix
        for (int i = 0; i < R; i++) {
            for (int j = i + 1; j < C; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse each row
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][C - 1 - j];
                matrix[i][C - 1 - j] = temp;
            }
        }
    }
}
