MAX=float('inf')
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        def f(grid,row,col,dp=None):
            if dp is None:
                dp={}
            
            # if you have crossed anywhere outside
            if row < 0 or col < 0:
                return MAX
            # if you are at the point (start)
            if row == 0 and col == 0:
                return grid[row][col]

            # if row,col already computed
            if (row,col) in dp:
                return dp[(row,col)]

            cost=grid[row][col]
            # you have two opts
            top=f(grid,row-1,col,dp)
            left=f(grid,row,col-1,dp)
            # pick the minimum
            dp[(row,col)]=cost+min(top,left)
            # return current ans
            return dp[(row,col)]
        
        # get the row
        R=len(grid)
        # get the col
        C=len(grid[0])
        return f(grid,R-1,C-1)
        