class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        # get the size of grid
        n = len(grid)
        # n x n grid to hold all numbers
        dp = [0 for _ in range(n*n + 1)]

        # just increment count of the elem appearing
        for i in range(n):
            for j in range(n):
                dp[grid[i][j]] += 1

        # to return the ans
        result = [0,0]
        # just iterate and fill the ans
        for i in range(1, len(dp)):
            if dp[i] == 2:
                result[0]=i # repeat
            elif dp[i] == 0:
                result[1] = i # missing
        
        # happy ending ...
        return result