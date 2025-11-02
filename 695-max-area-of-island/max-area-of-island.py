class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        R = len(grid)
        C = len(grid[0]) 

        maxarea = 0

        def dfs(row:int, col: int):
            if not (0 <= row < R and 0 <= col < C) or grid[row][col] == 0: return 0
            
            grid[row][col] = 0
            area = 1
            for dr, dc in [(0,-1), (-1,0), (0,1), (1,0)]: area += dfs(row+dr, col+dc)

            return area

        for row in range(R):
            for col in range(C):
                if grid[row][col] == 0: continue
                area = dfs(row, col)
                maxarea = max(area, maxarea)

        return maxarea