class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        R = len(grid)
        C = len(grid[0])
        visited = set()
        pq = [(0, 0, 0)]  # (cost, row, col)
        dirs = {1: (0, 1), 2: (0, -1), 3: (1, 0), 4: (-1, 0)}
        while pq:
            cost, r, c = heapq.heappop(pq)
            if (r, c) == (R - 1, C - 1):
                return cost
            if (r, c) in visited:
                continue
            visited.add((r, c))
            for v, di in dirs.items():
                nr, nc = r + di[0], c + di[1]
                if ((nr, nc) not in visited) and (0 <= nr < R and 0 <= nc < C):
                    heapq.heappush(pq, (cost + (0 if v == grid[r][c] else 1), nr, nc))

        return 0
