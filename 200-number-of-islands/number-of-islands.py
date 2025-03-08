class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        R = len(grid)
        C = len(grid[0])

        islands = 0

        for row in range(R):
            for col in range(C):
                if grid[row][col] == "1":
                    self.dfs(grid, row, col, R, C)
                    islands += 1

        return islands

    def dfs(self, grid, row, col, R, C):
        grid[row][col]="X"

        dirs = [ [-1,0], [0, 1], [1,0], [0, -1] ]

        for x, y in dirs:
            nrow = row + x
            ncol = col + y

            if nrow < 0 or nrow >= R or ncol < 0 or ncol >= C or grid[nrow][ncol] != "1":
                continue

            self.dfs(grid, nrow, ncol, R, C)

        # grid[row][col]=1