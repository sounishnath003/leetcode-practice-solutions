from collections import deque
from typing import List

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        R = len(grid)
        if R == 0 or grid[0][0] == 1 or grid[R - 1][R - 1] == 1:
            return -1

        queue = deque([(0, 0, 1)])  # (row, col, steps)
        visited = {(0, 0)}  # Using a set for faster lookups

        dirs = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, 1), (1, 0), (1, -1)]

        while queue:
            row, col, steps = queue.popleft()

            if row == R - 1 and col == R - 1:
                return steps

            for dr, dc in dirs:
                nrow, ncol = row + dr, col + dc

                if 0 <= nrow < R and 0 <= ncol < R and grid[nrow][ncol] == 0 and (nrow, ncol) not in visited:
                    queue.append((nrow, ncol, steps + 1))
                    visited.add((nrow, ncol))

        return -1