class Solution:
    def minDays(self, grid: List[List[int]]) -> int:
        # get the R and C of the grid
        R=len(grid)
        C=len(grid[0])

        """
        Observations:
        - grid e 0 or >=2 1 cell thakbe hobe -> tokhon e disconnected bolbo
        """
        # just for the easy readible code
        WATER=0
        LAND=1

        # count number of islands on the grid
        def get_islands(grid) -> int:
            """retuns the number of islands in the grid"""
            visited = [[False for _ in range(C)] for _ in range(R)]

            def dfs(row, col) -> None:
                if (row < 0 or col < 0 or row >= R or col >= C or visited[row][col] or grid[row][col] == WATER):
                    return
                
                visited[row][col] = True
                for dr, dc in [(0,1),(1,0),(-1,0),(0,-1)]:
                    dfs(row + dr, col + dc)

            islands = 0
            for row in range(R):
                for col in range(C):
                    if grid[row][col] == LAND and not visited[row][col]:
                        dfs(row,col)
                        islands +=1 

            return islands

        # get the number of islands
        islands=get_islands(grid)
        # as per the questions if islansd count != 1 it is disconnected
        if islands != 1:
            return 0 # you require no day ;;;; spend 0 days
        
        # STEP 2: try removing each land to see if it disconnects
        for row in range(R):
            for col in range(C):
                if grid[row][col] == LAND:
                    # change it to WATER block
                    grid[row][col] = WATER
                    if get_islands(grid) != 1:
                        return 1
                    # back track
                    grid[row][col] = LAND
        
        # if not disconnected try removing any 2 cells    
        return 2