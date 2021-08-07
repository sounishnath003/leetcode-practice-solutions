class Solution {
    public int numTrees(int n) {
        
        int[] dp = new int [n+1];
        dp[0] = 1;
        
        for (int i = 1; i < n + 1; i++) {
            for (int root = 1 ; root <= i; root++)
            {
                dp[i] += dp[root-1] * dp[i - root] ;
            }
        }
        
        return dp[n];
    }
}
​
