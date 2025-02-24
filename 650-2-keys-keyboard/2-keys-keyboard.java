class Solution {
    public int minSteps(int n) {
     if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i; // Initialize with the worst-case scenario (n pastes)
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j);
                    break; // Found the first (and best) factor
                }
            }
        }
        return dp[n];
    }
}
/*
// 1  2  4  8  16 32 (2x times exponential increment)
// AAAAAAAA|AAAAAAAA

// AA

N = 1, 2
N = 2, 4
N = 3, 8
N = 4, 16
N = 5, 32
N = 2^x = N

2 log10 (x) = log10 N
log10 (x) = log10 (N) / log10(2)
*/