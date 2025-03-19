class Solution:
    def tapping_rain_water2(self, arr):
        n=len(arr)
        left_walls=[0 for _ in range(n)]
        left_walls[0] = arr[0]
        # traverse from left to right and store the immdediate bigger buildings
        for i in range(1,n):
            left_walls[i] = max(arr[i], left_walls[i-1])
        
        right_walls=[0 for _ in range(n)]
        right_walls[n-1] = arr[n-1]
        # traverse from right to left and store the immdediate bigger builders
        for i in range(n-2, -1, -1):
            right_walls[i] = max(arr[i], right_walls[i+1])

        # result
        water=0
        # traverse and keep building and calc the water
        for i in range(n):
            lefth=left_walls[i]
            righth=right_walls[i]
            
            water += min(lefth, righth) - arr[i]

        return water

    def trap(self, height: List[int]) -> int:
        return self.tapping_rain_water2(height)