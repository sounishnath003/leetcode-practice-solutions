class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        """we can think of a BFS traversal on grid to go from (0,0) -> (r,c)"""
        R = len(grid)
        C = len(grid[0])
        # define the visisted list
        visited = set()
        # declare the queue to hold the nodes
        pq = []  # (cost, (row,col)) # min heap
        # add the starting point (0,0)
        heapq.heappush(pq, (grid[0][0], 0, 0))
        # directions
        dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        # process the queue node one at a time
        while pq:
            # pop from the pq
            costf, row, col = heapq.heappop(pq)
            if row == R - 1 and col == C - 1:
                return costf
            if (row, col) in visited:
                continue
            # mark the node as visisted
            visited.add((row, col))
            # check it;'s all 4 directions
            for k in dirs:
                nrow = row + k[0]
                ncol = col + k[1]
                # if it is outside the boundary do not consider them
                if (nrow >= R or nrow < 0 or ncol >= C or ncol < 0) or (
                    (nrow, ncol) in visited
                ):
                    continue
                # if the node is not visisted add into pq
                heapq.heappush(
                    pq,
                    (
                        max(costf, grid[nrow][ncol]),
                        nrow,
                        ncol,
                    ),
                )

        return 0
