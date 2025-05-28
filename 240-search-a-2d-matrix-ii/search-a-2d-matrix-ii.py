class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        R=len(matrix)
        C=len(matrix[0])

        row=0
        col=C-1
        
        while row < R and col >= 0:
            if matrix[row][col] > target:
                col -=1
            elif matrix[row][col] < target:
                row +=1
            else:
                return True

        return False
        
    def searchMatrix2(self, matrix: List[List[int]], target: int) -> bool:
        R=len(matrix)
        C=len(matrix[0])

        # iterate over the rows
        for row in range(R):
            row=matrix[row]
            low=row[0]
            high=row[C-1]
            if low > target or target > high:
                continue
            
            low=0
            high=C-1

            while low <= high:
                mid=(low+high)//2
                if row[mid] > target:
                    high=mid-1
                elif row[mid] < target:
                    low=mid+1
                else:
                    return True

        return False