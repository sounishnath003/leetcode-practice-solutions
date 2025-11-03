class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        R = len(grid)
        C = len(grid[0]) 
        
        time = 0
        fresh_oranges = sum(1 for row in range(R) for col in range(C) if grid[row][col] == 1)
        q = deque([(row, col) for row in range(R) for col in range(C) if grid[row][col] == 2])

        while q:
            qs = len(q)
            rotted = False

            for _ in range(qs):
                row, col = q.popleft()
                for dr, dc in [(0,-1),(-1,0),(0,1),(1,0)]:
                    nrow=row+dr
                    ncol=col+dc
                    if not(0 <= nrow < R and 0 <= ncol < C) or grid[nrow][ncol] != 1: continue
                    grid[nrow][ncol] = 2 # rotting
                    rotted = True
                    fresh_oranges -= 1
                    q.append((nrow, ncol))

            if rotted: time += 1

        return time if fresh_oranges == 0 else -1