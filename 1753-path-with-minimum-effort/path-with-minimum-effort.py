class Solution:
    def minimumEffortPath(self, grid: list[list[int]]) -> int:
        """
        1. Optimized
            1. Looks like a weighted cost grid. Hinting towards Dijsktra algorithm
            2. Store the (cost, cell) in min heap and try to reach the R-1,C-1 cell
            3. can go 4 directions.
        """

        R, C = len(grid), len(grid[0])
        pq = [(0,0,0)] # cost, row, cell
        dist = defaultdict(lambda: float("inf"))

        def safe(row:int, col:int) -> bool:
            return (0 <= row < R and 0 <= col < C)

        while pq:
            cost, row, col = heapq.heappop(pq)
            if (row,col) == (R-1,C-1): return cost
            if cost > dist[(row,col)]: continue

            for dr, dc in [(0,-1),(-1,0),(0,1),(1,0)]:
                nrow, ncol = row+dr, col + dc
                if safe(nrow, ncol):
                    ncost = max(abs(grid[row][col] - grid[nrow][ncol]), cost)
                    if ncost < dist[(nrow,ncol)]:
                        dist[(nrow,ncol)] = ncost
                        heapq.heappush(pq, ( ncost, nrow, ncol ))

        return dist[(R-1,C-1)]