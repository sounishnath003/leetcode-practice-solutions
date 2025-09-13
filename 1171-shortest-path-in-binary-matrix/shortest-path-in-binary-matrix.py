class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        """finds the shortest clear path in a binary grid connect 8-directions"""
        # get the length of grid
        R = len(grid)
        C = len(grid[0])
        # shortest clear path -> (0,0) -> (R,C) only visits cells with value 0
        # if there are no paths -> simply return -1

        # If the start or end is blocked, return -1 immediately
        if grid[0][0] != 0 or grid[R-1][C-1] != 0:
            return -1

        # let's think: we need to find smallest; maybe we can think of "BFS"
        # queue + weighted exploration
        q = deque()
        q.append((0, 0, 1))  # (row, col, steps) - steps start at 1 because (0,0) is counted as a step
        visited = set()
        visited.add((0, 0))
        # iterate over the queue and find the smallest
        while q:
            r, c, steps = q.popleft()
            # check if the node is the target node
            if (r, c) == (R-1, C-1):
                return steps
            # explore the 8-directions
            for dr, dc in [(-1,0), (1,0), (0,-1), (0,1), (-1,-1), (-1,1), (1,-1), (1,1)]:
                nr = r + dr
                nc = c + dc
                # check bounds, not visited, and cell is clear (0)
                if 0 <= nr < R and 0 <= nc < C and (nr, nc) not in visited and grid[nr][nc] == 0:
                    q.append((nr, nc, steps + 1))
                    visited.add((nr, nc))
        # if you are not able to find any path
        return -1