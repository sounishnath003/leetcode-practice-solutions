class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        n = len(nums)
        # diff array of size n+1 to handle r+1 boundary
        diff = [0] * (n + 1)
        
        # 1. Mark the boundaries for each query
        for l, r in queries:
            diff[l] += 1
            if r + 1 < n:
                diff[r + 1] -= 1
                
        # 2. Compute the prefix sum to find total decrement "budget" at each index
        current_capacity = 0
        for i in range(n):
            current_capacity += diff[i]
            
            # 3. If the capacity is less than the value, we can't zero it out
            if current_capacity < nums[i]:
                return False
                
        return True