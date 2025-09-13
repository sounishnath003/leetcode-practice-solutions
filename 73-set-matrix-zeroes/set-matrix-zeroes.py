class Solution:
    def setZeroes(self, grid: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # we will use the matrix first row as 0 or not; similarly the 1st column
        # as a marker
        is_first_row_zero = any([True if grid[0][col] == 0 else False for col in range(len(grid[0]))])
        is_first_col_zero = any([True if grid[row][0] == 0 else False for row in range(len(grid))])
        
        # now check and update the markers if (1,1) -> (n,n) has anyone zero?
        rows, cols = len(grid), len(grid[0])
        for row in range(1, rows):
            for col in range(1, cols):
                # if the current element is a zero?
                if grid[row][col] == 0:
                    # mark the 1st row and col as zero
                    grid[0][col] = 0
                    grid[row][0] = 0

        # now you have to make the cells zero, for (1,1,) -> (n,n) where the 1st
        # row or col is zero already?
        for row in range(1, rows):
            # check what is the val in 1st row[0]
            if grid[row][0] == 0:
                for col in range(cols):
                    grid[row][col] = 0

        for col in range(1, cols):
            # check what is the val in 1st row[0]
            if grid[0][col] == 0:
                for row in range(rows):
                    grid[row][col] = 0

        # you are pending with only the 1st markers that u have filled
        if is_first_row_zero:
            for col in range(cols):
                grid[0][col] = 0

        if is_first_col_zero:
            for row in range(rows):
                grid[row][0] = 0