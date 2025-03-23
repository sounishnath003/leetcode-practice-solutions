from collections import *


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        def safe(grid, nrow, ncol, R, C, visited):
            return (
                nrow >= 0
                and nrow < R
                and ncol >= 0
                and ncol < C
                and (nrow, ncol) not in visited
                and grid[nrow][ncol] == 0
            )

        # you can only move to 0th cells
        # shortest path we must use BFS
        R = len(grid)
        C = len(grid[0])
        queue = deque()  # (row, col, steps)
        visited = set()  # (row, col)
        # prepare the 8 directions.
        dirs = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, 1), (1, 0), (1, -1)]
        if grid[0][0] == 1:
            return -1
        # start from top-left corner
        queue.append((0, 0, 0))
        # iterate on the queue and visit all the cells
        while queue:
            row, col, steps = queue.popleft()
            if (row, col) in visited:
                continue
            # mark the node as visited
            visited.add(
                (
                    row,
                    col,
                )
            )
            # check if you have reached the (bottom right corner)
            if row == R - 1 and col == C - 1:
                return steps + 1
            # visit all the 8 directions
            for k in dirs:
                nrow = row + k[0]
                ncol = col + k[1]
                if not safe(grid, nrow, ncol, R, C, visited):
                    continue
                # add the right node into queue
                queue.append(
                    (
                        nrow,
                        ncol,
                        steps + 1,
                    )
                )

        return -1
