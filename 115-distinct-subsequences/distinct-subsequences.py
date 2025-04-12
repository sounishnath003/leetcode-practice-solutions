class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        from functools import lru_cache

        @lru_cache(None)
        def dp(i, j):
            if j == len(t):  # matched full t
                return 1
            if i == len(s):  # s is exhausted but t is not
                return 0

            if s[i] == t[j]:
                # pick or not pick
                return dp(i+1, j+1) + dp(i+1, j)
            else:
                # skip s[i]
                return dp(i+1, j)

        return dp(0, 0)
