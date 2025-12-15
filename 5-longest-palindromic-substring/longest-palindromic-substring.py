class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        def fn(i):
            nonlocal res
            if i == len(s):
                return

            for j in range(i, len(s)):
                t=s[i:j+1]
                if t == t[::-1]:
                    res = t if len(t) > len(res) else res
                    fn(j+1)

        n = len(s)
        dp = [[False] * (n) for _ in range(n)]

        for gap in range(n):
            for i in range(n - gap):
                j = i + gap
                if gap == 0:
                    dp[i][j] = True
                elif gap == 1:
                    dp[i][j] = s[i] == s[j]
                else:
                    dp[i][j] = dp[i+1][j-1] and (s[i] == s[j])

                if dp[i][j]:
                    res = s[i : j + 1] if len(res) < len(s[i : j + 1]) else res


        return res