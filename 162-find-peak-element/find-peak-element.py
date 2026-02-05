class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        
        if nums[0] > nums[1]:
            return 0
        if n-2 >= 0 and nums[n-1] > nums[n-2]:
            return n-1
        
        low, high = 1, n-2
        def is_peak(idx):
            return (
                idx > 0 and idx < n-1 
                and nums[idx] > nums[idx-1] 
                and nums[idx] > nums[idx+1]
            )
        
        while low <= high:
            mid = (low + high) // 2
            if is_peak(mid):
                return mid
            if nums[mid] > nums[mid-1]:
                low = mid + 1
            else:
                high = mid - 1
                
        return -1