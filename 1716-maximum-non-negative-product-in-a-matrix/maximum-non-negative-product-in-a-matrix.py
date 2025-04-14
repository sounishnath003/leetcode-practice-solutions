from typing import List

class Solution:
    def maxProductPath(self, grid: List[List[int]]) -> int:
        MOD = 10**9 + 7
        R, C = len(grid), len(grid[0])
        
        max_dp = [[0] * C for _ in range(R)]
        min_dp = [[0] * C for _ in range(R)]
        
        max_dp[0][0] = min_dp[0][0] = grid[0][0]

        for r in range(R):
            for c in range(C):
                if r == 0 and c == 0:
                    continue
                curr = grid[r][c]
                candidates = []

                if r > 0:
                    candidates += [
                        curr * max_dp[r-1][c],
                        curr * min_dp[r-1][c]
                    ]
                if c > 0:
                    candidates += [
                        curr * max_dp[r][c-1],
                        curr * min_dp[r][c-1]
                    ]

                max_dp[r][c] = max(candidates)
                min_dp[r][c] = min(candidates)

        
        result = max_dp[R-1][C-1]
        return result % MOD if result >= 0 else -1
