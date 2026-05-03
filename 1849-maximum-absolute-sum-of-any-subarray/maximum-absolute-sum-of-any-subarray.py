class Solution:
    def maxAbsoluteSum(self, nums: list[int]) -> int:
        gmax = 0
        gmin = 0
        curr_max = 0
        curr_min = 0
        
        for x in nums:
            # Standard Kadane's for Max Sum
            curr_max = max(x, curr_max + x)
            gmax = max(gmax, curr_max)
            
            # Standard Kadane's for Min Sum
            curr_min = min(x, curr_min + x)
            gmin = min(gmin, curr_min)
                
        return max(map(abs, (gmin, gmax)))
