
class Solution:
    def calculateMinimumHP(self, grid: List[List[int]]) -> int:
        """
        if cell has -ve -> king losses health
        if cell has +ve or 0 -> kind gains health

        can go RIGHT or DOWN
        return the minimum health that kind needs so he can rescue princess
        """
        
        R, C = len(grid), len(grid[0])
        MAX = float("inf")
        dp={}

        def f(grid, row, col):
            if row >= R or col >= C:
                return MAX
            if (row, col) == (R-1,C-1):
                return max(1, 1-grid[row][col])
            
            if (row,col) in dp:
                return dp[(row,col)]
            # go right or down
            right=f(grid,row,col+1)
            down=f(grid,row+1,col)
            life=min(right,down)
            
            dp[(row,col)]=max(1, life-grid[row][col])
            return dp[(row,col)]
        
        return f(grid,0,0)