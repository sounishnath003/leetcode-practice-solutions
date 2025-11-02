class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        R = len(grid)
        C = len(grid[0])

        islands = 0
        visited = set()

        def dfs(row: int, col: int):
            if not (0 <= row < R and 0 <= col < C) or grid[row][col] == "0" or (row, col) in visited: return 0
            
            visited.add((row, col))

            for dr, dc in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                dfs(row + dr, col + dc)
                
            return 1

        for row in range(R):
            for col in range(C):
                islands += dfs(row, col) if grid[row][col] == "1" else 0

        return islands