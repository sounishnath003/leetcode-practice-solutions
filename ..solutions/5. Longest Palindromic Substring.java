class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        int maxLen = 1;
        int maxCenter = 0;
​
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
                maxCenter = i;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        maxLen = len;
                        maxCenter = i;
                    }
                }
            }
        }
        return s.substring(maxCenter, maxCenter + maxLen);
    }
}

// One Of The Easiest Implementation Solution
// However need to fix some rare cases

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0)
            return "";

        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();

        int[][] dp = new int[n + 1][n + 1];

        int maxlen = 0;
        int startIndex = -1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                char x = s.charAt(i - 1);
                char y = t.charAt(j - 1);

                if (x == y) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (maxlen < dp[i][j]) {
                        maxlen = dp[i][j];
                        startIndex = i - dp[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return s.substring(startIndex, startIndex + maxlen);
    }
}
