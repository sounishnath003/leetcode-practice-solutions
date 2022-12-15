class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    char sc = s.charAt(i - 1);
                    char tc = t.charAt(j - 1);
                    if (sc == tc) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        int tkn = dp[i][j - 1];
                        int ntkn = dp[i - 1][j];
                        dp[i][j] = Math.max(tkn, ntkn);
                    }
                }
            }
        }
        return dp[n][m];
    }
}
