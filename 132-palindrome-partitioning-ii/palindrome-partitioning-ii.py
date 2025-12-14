class Solution:
    def minCut(self, s: str) -> int:
        # LC: 132
        def palindrome_parition_min_cuts(s) -> int:
            def is_palindrome(s: str) -> bool: return s == s[::-1]

            def parition(s, i, dp):
                if len(s) == i:
                    return -1

                if i in dp: return dp[i]
                
                ans = float("inf")
                for j in range(i, len(s)):
                    t = s[i:j+1]
                    if is_palindrome(t):
                        cuts = 1 + parition(s, j+1, dp)
                        ans = min(ans, cuts)
                dp[i] = ans
                return ans

            # return parition(s, 0, dp={}) 

            n = len(s)
            dp = [float("inf")] * (n + 1)
            dp[n] = -1

            # finding is_palindrome is slower:: make it faster
            pal_dp = [[False] * n for _ in range(n)]

            for gap in range(1, n+1):
                for i in range(n - gap + 1):
                    j = i + gap - 1
                    if s[i] == s[j]:
                        if gap == 1:
                            pal_dp[i][j] = True
                        elif gap == 2:
                            pal_dp[i][j] = True
                        elif gap > 2:
                            pal_dp[i][j] = True and pal_dp[i+1][j-1]

            # other case:
            for i in range(n-1, -1, -1):
                for j in range(i, n):
                    # if is_palindrome(s[i:j+1]):
                    if pal_dp[i][j]:
                        cuts = 1 + dp[j+1]
                        dp[i] = min(dp[i], cuts)

            return dp[0]

        return palindrome_parition_min_cuts(s)