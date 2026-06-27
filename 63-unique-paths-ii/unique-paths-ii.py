class Solution:
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        """returns the possible unique paths to reach R-1,C-1 overcoming obstacles"""
        # define the cell size
        R, C = len(grid), len(grid[0])
        dp = [[0] * C for _ in range(R)]
        # edge case: if 0th cell is obstacles
        if grid[0][0] == 1: return 0
        # define the base case:
        # why 1: because you are either go only right or down:
        # i am not summing up the cells rather counting the ways to reach the cell
        for row in range(R): 
            if grid[row][0] == 1:break
            dp[row][0] = 1
        for col in range(C): 
            if grid[0][col] == 1:
                break
            dp[0][col] = 1
            
        # run for the othercells
        for row in range(1, R):
            for col in range(1, C):
                if grid[row][col] == 1:
                    continue
                op1 = dp[row-1][col]
                op2 = dp[row][col-1]
                # total ways to reach the cell is the op1 + op2
                dp[row][col] = op1 + op2

        return dp[R-1][C-1]
        