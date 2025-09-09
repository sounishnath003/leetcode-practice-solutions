class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        dp = [0 for _ in range(n*n + 1)]

        for i in range(n):
            for j in range(n):
                dp[grid[i][j]] += 1

        result = [0,0]

        for i in range(1, len(dp)):
            if dp[i] == 2:
                result[0]=i # repeat
            elif dp[i] == 0:
                result[1] = i # missing

        return result