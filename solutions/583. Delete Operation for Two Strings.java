class Solution {
    private int[][] memo = new int [600][600];
    public int minDistance(String word1, String word2) {
        /*
            == very easy and self explanatory ==
            * just find longest common subsequence and 
            * (word1.length + word2.length - 2 * lcslength) = GET The Job DONE!
        */
        for (int i = 0; i < memo.length; i++) 
            Arrays.fill(memo[i], -1);
        
        int n = word1.length(), m = word2.length();
        int lcsLength = longestCommonSubsequence(word1, word2, n - 1, m - 1);
        return (word1.length() + word2.length() - 2 * (lcsLength));
    }
​
    private int longestCommonSubsequence(String a, String b, int n, int m) {
        if (n < 0 || m < 0) return 0;
        if (memo[n][m] != -1) return memo[n][m];
        if (a.charAt(n) == b.charAt(m)) {
            return memo[n][m] = 1 + longestCommonSubsequence(a, b, n-1, m-1);
        }
        // faith
        int p = longestCommonSubsequence(a, b, n-1, m);
        int q = longestCommonSubsequence(a, b, n, m-1);
        return memo[n][m] = Math.max(p, q);
    }
}
