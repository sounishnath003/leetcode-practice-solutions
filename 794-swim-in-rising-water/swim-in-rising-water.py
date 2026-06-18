class Solution:
    def swimInWater(self, grid: list[list[int]]) -> int:
        # Looks like a BFS level order / Dijsktra problem.
        # we need to find the minimum possible time to reach the end (r-1,c-1) cell from (0,0)
        R, C = len(grid), len(grid[0])

        def safe(row:int, col:int) -> bool:
            return (0 <= row < R and 0 <= col < C)

        pq = [(grid[0][0], 0,0)]
        visited = set([(0,0)])

        while pq:
            cost, row, col = heapq.heappop(pq)

            if (row, col) == (R-1,C-1):
                return cost

            # go to all 4 directions
            for dr, dc in [(0,-1),(-1,0),(0,1),(1,0)]:
                nrow, ncol = row + dr, col + dc
                if safe(nrow,ncol) and (nrow,ncol) not in visited:
                    visited.add((nrow,ncol))
                    heapq.heappush(pq, (max(cost, grid[nrow][ncol]), nrow, ncol))

        return -1