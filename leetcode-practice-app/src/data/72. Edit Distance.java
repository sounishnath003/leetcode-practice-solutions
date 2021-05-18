class Solution {
    private int[][] memo;
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int n = word1.length();
        int m = word2.length();
        memo = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0)
                    memo[i][j] = j;
                else if (j == 0)
                    memo[i][j] = i;
                else if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    memo[i][j] = memo[i-1][j-1] + 0;
                } else {
                    int a = memo[i][j-1];
                    int b = memo[i-1][j];
                    int c = memo[i-1][j-1];
                    memo[i][j] = 1 + Math.min(a, Math.min(b, c));
                }
            }
        }
        return memo[n][m];
    }
​
}
