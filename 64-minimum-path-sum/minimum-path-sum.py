class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        R = len(grid)
        C = len(grid[0])

        # stand at 0th row
        for col in range(1, C):
            grid[0][col] += grid[0][col-1]

        # stand at 0th col
        for row in range(1, R):
            grid[row][0] += grid[row-1][0]

        for row in range(1, R):
            for col in range(1, C):
                grid[row][col] += min(grid[row-1][col], grid[row][col-1])

        return grid[R-1][C-1] 