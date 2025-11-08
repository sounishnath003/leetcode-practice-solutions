class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        n=len(text1)
        m=len(text2)

        dp = {}

        def f(n,m) -> int:
            nonlocal dp, text1, text2
            if n == 0 or m == 0: return 0
            if (n,m) in dp: return dp[(n,m)]
            # two options
            if text1[n-1]==text2[m-1]:
                dp[(n,m)] = 1 + f(n-1,m-1)
                return dp[(n,m)]

            dp[(n,m)] = max(f(n-1,m), f(n,m-1))
            return dp[(n,m)]

        # return f(n, m)

        dp = [[0] * (m+1) for _ in range(n+1)]

        for i in range(1, n+1):
            for j in range(1, m+1):
                if text1[i-1]==text2[j-1]:
                    dp[i][j] = 1 + dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])

        return dp[n][m]
