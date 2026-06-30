class Solution:
    def minInsertions(self, s: str) -> int:
        n = len(s)
        dp = [[0] * (n+1) for _ in range(n+1)]
        t = s[::-1]

        for i in range(1,n+1):
            for j in range(1,n+1):
                if s[i-1] == t[j-1]:
                    dp[i][j] = 1 + dp[i-1][j-1]
                else:
                    op1, op2 = dp[i-1][j], dp[i][j-1]
                    dp[i][j] = max(op1,op2)

        return n - dp[n][n]
