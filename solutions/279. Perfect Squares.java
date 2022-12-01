class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = n;
            for (int j = 1; j * j <= i; j++) {
                int sq = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - sq]);
            }
        }
        return dp[n];
    }
​
    private Map<Integer, Integer> map = new HashMap<>();
​
    private int func(int n) {
        if (n <= 0) {
            return n == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (map.containsKey(n))
            return map.get(n);
            
        int miniways = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int c = 1 + func(n - (i * i));
            map.put(n, c);
            miniways = Math.min(miniways, c);
        }
        return miniways;
    }
​
}
