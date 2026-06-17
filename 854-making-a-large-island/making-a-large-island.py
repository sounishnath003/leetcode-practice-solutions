
# LC: 827
# https://leetcode.com/problems/making-a-large-island/description/

class Solution:
    def largestIsland(self, grid: list[list[int]]) -> int:
        """
        1. Thoughts:
            [Optimized]? -> Union FInd + Process Zero cells
            1.1. If we use Union by Size method and Try to find how many components we have
            1.2. Also track the size of the components, the node is going to be part of.
            1.3. If ZERO cell; and we try to add into our component, will it turn to a bigger land?
            1.4. Is there any easy way to find a conjugal point (cell?)? like act bridge between 2 comp?

            1.5. [Simplify]: TC: O(RxC); SC: O(RxC)
                1.5.1. Build the DSU track the component parent and component Size.: O(RxC)
                1.5.2. Process every ZERO cell and update gmax. : O(RxC)

            [Bruteforce] : TC: O(R x C x SIZE) ; SC: O(R x C)
            1.5. Looks like a recursion DFS problem. dfs(row, col, operations) and get the size of the island?
            1.6. Run DFS from each cell and see if you can achieve largest size island update the gmax and return ans.
        """

        R, C = len(grid), len(grid[0])

        class UnionFind:
            def __init__(self, n):
                self.parent = list(range(n))
                self.size = [1] * n

            def find(self, x):
                if self.parent[x] != x:
                    self.parent[x] = self.find(self.parent[x])  # path compression
                return self.parent[x]

            def union(self, a, b):
                ra = self.find(a)
                rb = self.find(b)

                if ra == rb:
                    return

                # union by size
                if self.size[ra] < self.size[rb]:
                    ra, rb = rb, ra

                self.parent[rb] = ra
                self.size[ra] += self.size[rb]

        gmax = 0
        dirs = [(0,-1),(-1,0),(0,1),(1,0)]
        land, water = 1,0

        def safe(row:int, col:int) -> bool:
            return (0 <= row < R and 0 <= col < C)
        
        uf = UnionFind(R*C)

        for row in range(R):
            for col in range(C):
                if grid[row][col] == land:
                    cell = row * C + col
                    # go to all its neighbors
                    for dr, dc in dirs:
                        nrow, ncol = row + dr, col + dc
                        if not safe(nrow,ncol) or grid[nrow][ncol] == water: continue
                        nei_cell = nrow * C + ncol
                        uf.union(cell, nei_cell)

        # corner case:    
        # preload the maximum component size in gmax (probably a grid input has no water cells?)
        for cell in range(R * C):
            if uf.find(cell) == cell: # root cell
                gmax = max(gmax, uf.size[cell])
                    
        # process all zeros
        for row in range(R):
            for col in range(C):
                if grid[row][col] == water:
                    # identify all its directions
                    parents = set()
                    for dr, dc in dirs:
                        nrow, ncol = row + dr, col + dc
                        if not safe(nrow,ncol) or grid[nrow][ncol] == water: continue
                        cell = nrow * C + ncol
                        parents.add(uf.find(cell))

                    total_comp_size = 1 + sum(map(lambda p: uf.size[p], parents))
                    gmax = max(gmax, total_comp_size)

        return gmax

