class Solution:
    def solve(self, grid: List[List[str]]) -> None:
        """
        1. Optimized: O(RxC) ; SC: O(N)
            1. As mentioned in Q, we cannot touch the edge cells with O, we will mark them #
            2. Then we simply FLIP the O -> X (for entire grid, (0,R), (0,C)) except the #
                2.1. if row,col == 'O' -> 'X'
                2.2. if row,col == '#' -> 'O'
            3. Return the grid

        Note: Ei question e clearly mention kora nei, but ekhane bolte chaiche, jodi EDGE e O thake
        tobe oi edge theke connected joto O cell thakbe, they cannot be part of the surrounded region.

        So, ami sob edged cell contains O --> # mark kore dicchi, ar normally baki cell ke O -> X kore debo.
        >>> NO DFS/BFS required!
        """
        R, C = len(grid), len(grid[0])

        def is_boundary(row:int, col:int) -> int:
            return row in (0,R-1) or col in (0,C-1)

        def dfs(row:int, col:int):
            grid[row][col] = '#'
            dirs = [(0,-1),(-1,0),(0,1),(1,0)]
            for dr, dc in dirs:
                nrow, ncol = row + dr, col + dc
                if (0 <= nrow < R and 0 <= ncol < C) and (grid[nrow][ncol] == 'O'):
                    dfs(nrow,ncol)

        for row in range(R):
            for col in range(C):
                if is_boundary(row,col) and grid[row][col] == 'O':
                    dfs(row,col)

        for row in range(R):
            for col in range(C):
                if grid[row][col] == 'O':
                    grid[row][col] = 'X'
                elif grid[row][col] == '#':
                    grid[row][col] = 'O'