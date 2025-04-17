# https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/770/

from typing import List

class Solution:
    def rotate(self, grid: List[List[int]]) -> None:
        """
        Rotates the given 2D grid (matrix) 90 degrees clockwise in-place.
        Do not return anything, modify the matrix in-place instead.
        """
        R = len(grid)  # Number of rows in the grid
        C = len(grid[0])  # Number of columns in the grid

        # Step 1: Transpose the matrix (swap rows with columns)
        for row in range(R):
            for col in range(row, C):
                # Swap elements at (row, col) and (col, row)
                grid[row][col], grid[col][row] = grid[col][row], grid[row][col]

        # Step 2: Reverse each row to complete the 90-degree rotation
        for row, row_v in enumerate(grid):
            # Reverse the current row
            grid[row][:] = row_v[::-1]

        # The grid is now rotated 90 degrees clockwise
        return grid