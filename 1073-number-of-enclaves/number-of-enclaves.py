class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        """
        1. Bruteforce: O((RxC)^2 + O(V+E))
            1. Q is asking to tell if from the 1s, can you go out of the window?
            2. So, If I o DFS from all the cells with 1, can check if I can go out of the boundary?
            3. At last I may return # of total 1s - # of 1s from there I was able to go out?

        2. Optimized: TC: O(R x C)
            1. Apply the same rule surrounded regions, Start from the Boundary 1s.
            2. Mark all the 1s reachable from boundary 1s. as 1 --> 2
            3. Ones all operations is done; Then simply COUNT the # of 1s (left out)
        """

        R, C = len(grid), len(grid[0])

        def is_boundary(r:int, c:int) -> int:
            return (r == 0 or r == R-1 or c == 0 or c == C-1)
        
        def safe(r:int, c:int) -> int:
            return (0 <= r < R and 0 <= c < C)

        def dfs(row:int, col:int):
            grid[row][col] = 2

            dirs = [(-1,0),(0,1),(1,0),(0,-1)]
            for dr,dc in dirs:
                nrow,ncol = row+dr, col+dc
                
                if safe(nrow,ncol) and grid[nrow][ncol] == 1:
                    dfs(nrow,ncol)


        # Get all the boundary 1s and DFS and mark them 2. (checking how far we can reach?)
        for row in range(R):
            for col in range(C):
                if is_boundary(row,col) and grid[row][col] == 1:
                    dfs(row,col)

        # Simply count the left over 1s
        enclaves = 0
        for row in range(R):
            for col in range(C):
                if grid[row][col] == 1:
                    enclaves += 1


        return enclaves