class Solution {
    private int inf = 1_000_000_007;
​
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
​
        final int n = s.length();
        int[] dp = new int[n + 1];
​
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
​
        /*
         * actually everytime I got 2 possiblities: to check if the next character is a
         * valid number or not. ( num > 0) or to check if the next character is a valid
         * number or not. ( num == 0) so I can just use a single variable to represent
         * the number.
         * 
         * if curchar == '*' --> 9 ways if curchar > '0' ---> 1 ways
         * 
         * total curway would be multiple of (dp[i-1] + dp[i-2])
         */
​
        for (int i = 2; i <= n; i++) {
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);
​
            if (second == '*') {
                dp[i] += (9 * dp[i - 1]) % inf;
            } else if (second > '0') {
                dp[i] += dp[i - 1];
            }
​
            if (first == '1' && second == '*') {
                dp[i] += (9 * dp[i - 2]) % inf;
            } else if (first == '2' && second == '*') {
                dp[i] += (6 * dp[i - 2]) % inf;
            } else if ((first - '0') * 10 + (second - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
​
            if (first == '*') {
                if (second == '*') {
                    dp[i] += (15 * dp[i - 2]) % inf;
                } else if (second <= '6') {
                    dp[i] += (2 * dp[i - 2]) % inf;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
​
            dp[i] = dp[i] % inf;
        }
​
        System.out.println(Arrays.toString(dp));
        return dp[n] % inf;
    }
}
