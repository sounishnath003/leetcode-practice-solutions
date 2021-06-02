class Solution {
    public int countSubstrings(String s) {
        int foundSubstrings = 0;
​
        /*
         * return the number of palindromic substrings in it.
         * 
         * Intuition: dp[i][j] -> whether s.substring(i,j+1) is a palindrome? How?:
         * s.at(i) == a.at(j) as well as dp[i+1][j-1] is true!
         */
​
        final int n = s.length();
        int[][] dp = new int[n][n];
​
        for (int i = 0; i < n; i++) // means single char is palindrome
            dp[i][i] = 1;
​
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (i + 1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) ? 1 : 0);
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] > 0) ? 1 : 0;
                }
            }
        }
​
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                foundSubstrings += dp[i][j];
​
        return foundSubstrings;
    }
}
​
