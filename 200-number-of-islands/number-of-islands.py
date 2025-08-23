class Solution:
    def dfs(self, grid, row:int, col:int, R:int, C:int, visited:set) -> None:
        # visit the cell
        visited.add((row,col))
        # traverse all the neighbours and find all
        # you can only go 4 directions
        dr=[-1,0,1,0]
        dc=[0,1,0,-1]

        for k in range(4):
            nrow=row+dr[k]
            ncol=col+dc[k]

            # is safe then only go
            if nrow < 0 or nrow >= R or ncol < 0 or ncol >= C or grid[nrow][ncol]== '0' or ((nrow,ncol) in visited):
                continue

            self.dfs(grid,nrow,ncol,R,C,visited)

        return 

    def numIslands(self, grid: List[List[str]]) -> int:
        # get the rows and cols
        R,C=len(grid),len(grid[0])
        # store the visited nodes into a set
        visited=set()
        # store count the islands
        islands=0
        # traverse all rows,cols where it is a land only
        for row in range(R):
            for col in range(C):
                # cell is 0; it is water; skip that
                # also check, is (row,col) is not yet visited!! IMPORTANT
                if grid[row][col]=='0' or (row,col) in visited:
                    continue
                # perform a DFS
                self.dfs(grid, row, col, R, C, visited)
                # increment the count of islands
                islands += 1

        return islands