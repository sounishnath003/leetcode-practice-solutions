import typing

class Solution:
    def rotate(self, grid: typing.List[typing.List[int]]) -> typing.List[typing.List[int]]:
        def swap(grid: typing.List[typing.List[int]], row:int, col:int) -> None:
            """swaps out the elements at position (row, col)"""
            grid[row][col],grid[col][row] = grid[col][row], grid[row][col]
        
        R = len(grid)
        C = len(grid[0])
        # swap the elements (row,col) -> (col, row)
        for row in range(R):
            for col in range(row, C):
                swap(grid, row, col)

        # reverse every row [1,6,7] -> [7,6,1]
        for row in range(R):
            grid[row][:] = grid[row][::-1]
        # return grid
