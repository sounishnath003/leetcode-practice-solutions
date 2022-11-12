class Solution {
    private Long[][][] dp;
    private int[] dx = new int[] {1,-1,0,0};
    private int[] dy = new int[] {0,0,-1,1};
    private int mod = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Long[m+1][n+1][maxMove+1];
        return (int) _findPaths(m, n, maxMove, startRow, startColumn);
    }
    
    private long _findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // TODO Auto-generated method stub
​
        if (maxMove < 0)
            return 0;
​
        if (startRow == m || startColumn == n || startRow == -1 || startColumn == -1)
            return 1;
        
        if (dp[startRow][startColumn][maxMove] != null)
            return dp[startRow][startColumn][maxMove];
        
        long myways = 0;
        
        for(int k = 0; k < 4; k++) {
            long c = _findPaths(m, n, maxMove-1, startRow + dx[k], startColumn + dy[k]);
            myways = (myways + c) % mod;
        }
        
        dp[startRow][startColumn][maxMove] = myways;
        return myways;
    }
​
}
