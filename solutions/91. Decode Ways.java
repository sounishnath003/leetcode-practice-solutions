class Solution {
    public int numDecodings(String s) {
        final int n = s.length();
        if (n == 0) return 0;
​
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1 ;
​
        for (int i = 2; i < dp.length; i++) {
            String oneChar = s.substring(i-1, i);
            String twoChar = s.substring(i-2, i);
​
            int one = Integer.valueOf(oneChar);
            int two = Integer.valueOf(twoChar);
​
            if (one > 0) {
                dp[i] += dp[i-1];
            }
​
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i-2];
            }
        }
​
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
