class Solution {
    public int stoneGameVII(int[] stones) {
        final int n = stones.length;
        int[] dp = new int[n];
​
        for (int i = n-1; i >= 0; i--) {
            int temp = 0;
            int sumSoFar = stones[i];
            for (int j = i; j < n; j++) {
                if (i != j) {
                    sumSoFar += stones[j];
                    int a = sumSoFar - stones[j];
                    int b = sumSoFar - stones[i];
                    dp[j] = Math.max(a - temp, b-dp[j]);
                }
                temp = dp[j];
            }
        }
        return dp[n-1];
    }
}
