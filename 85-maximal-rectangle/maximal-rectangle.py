# LC: 85
# https://leetcode.com/problems/maximal-rectangle/description/

def largest_area_histogram(nums):
    def next_smaller_elements(nums):
        n=len(nums)
        stack = []
        result = [n] * n
        for i in range(n-1,-1,-1):
            height=nums[i]
            while stack and nums[stack[-1]] >= height: stack.pop()
            result[i] = stack[-1] if stack else n
            stack.append(i)
            
        return result
        
    def prev_smaller_elements(nums):
        n=len(nums)
        stack = []
        result = [-1] * n
        for i in range(n):
            height = nums[i]
            while stack and nums[stack[-1]] >= height:
                stack.pop()
            result[i] = stack[-1] if stack else -1
            stack.append(i)
            
        return result
        
    n=len(nums)
    pse = prev_smaller_elements(nums)
    nse = next_smaller_elements(nums)

    max_area = 0
    for i, height in enumerate(nums):
        width = nse[i] - pse[i] - 1
        area = height * width
        max_area = max(max_area, area)
        
    return max_area


class Solution:
    def maximalRectangle(self, grid: list[list[str]]) -> int:
        R, C = len(grid), len(grid[0])
        """
        1. Brute force: TC: O(N^4 +) ; SC: O(1)
            1. For every row and cells, find out the 1 cell
            2. Check how far maximum you can go and is that cell is valid?
            3. Explore the inner cells coordinates:
                3.1 for rx, cx in zip(range(r1, r2 + 1), range(c1, c2 + 1))
                3.2 calc the area; if cell has 0; immediately break out from loop.
        
        2. Optimzied: TC: O(N^2) ; SC: O(2N)
            1. Use the largest Area in Histogram concept
            2. Run that algorithm for every other rows.
            3. Calculate the maximum area you can get at every row
            4. Return that as answer / result.
        """

        gmax = 0
        grid = [list(map(int, grid[row])) for row in range(R)]
        print(grid)
        def precalculate_height_fn(row: int):
            if row == 0:
                return grid[row]
            for col in range(C):
                if grid[row][col] == 1: # Only add if the current cell is a '1'
                    grid[row][col] += grid[row-1][col]
                else:
                    grid[row][col] = 0 # If it's '0', the height resets to zero
            return grid[row]

        for row in range(R):
            heights = precalculate_height_fn(row)
            area = largest_area_histogram(heights)
            gmax = max(area, gmax)

        return gmax

