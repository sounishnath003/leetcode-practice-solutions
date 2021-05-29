class Solution {
    private int totalSolutions = 0;
     public int totalNQueens(int n) {
         boolean[] cols = new boolean[n];
         boolean[] rightDiagonal = new boolean[2 * n];
         boolean[] leftDiagonal = new boolean[2 * n];
         
         this.dfs(0,cols, leftDiagonal, rightDiagonal, n);
        return this.totalSolutions;
     }
​
    private void dfs(int currow, boolean[] cols, boolean[] leftDiagonal, boolean[] rightDiagonal, int n) {
        // TODO Auto-generated method stub
        
        if (currow == n) this.totalSolutions++;
        
        for (int col = 0; col < n; col++) {
            int id1 = currow + col; // basically leftDiagonalPosition
            // (row = 1, col = 0 -> id1 = 4 ==> 0 - 1 + 5 = 4 ) // basically rightDiagonalPosition
            int id2 = col - currow + n;
            
            if(cols[col] || leftDiagonal[id1] || rightDiagonal[id2]) continue;
            
            cols[col] = leftDiagonal[id1] = rightDiagonal[id2] = true;
            dfs(currow + 1, cols, leftDiagonal, rightDiagonal, n);
            cols[col] = leftDiagonal[id1] = rightDiagonal[id2] = false;
        }
    }
}
