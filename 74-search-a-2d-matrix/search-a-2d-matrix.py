class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """
        treat it like a linear array
        split the row and col into calc to fit the linear arr eq.
        """
        R=len(matrix) # 3
        C=len(matrix[0]) # 4
        n = R*C # 12

        low = 0
        high=n-1

        while low <= high:
            mid=(low+high)//2
            # get the row and col
            row=mid // C
            col=mid % C
            if matrix[row][col] > target:
                high=mid-1
            elif matrix[row][col] < target:
                low=mid+1
            else:
                return True

        return False