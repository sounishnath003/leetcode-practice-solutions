# LC: 930
# https://leetcode.com/problems/binary-subarrays-with-sum/
class Solution:
    def numSubarraysWithSum(self, nums: list[int], goal: int) -> int:
        """
        Optimized 1: TC: O(N) ; SC: O(N)
            1. Apply the Prefix Sum - K and Count of Subarray Formula with Hashmap:
        
        Optimizied 2: TC: O(N) ; SC: O(1)
            1. Use Sliding window 2 pointers and update the max window 
            2. When the sum of window > K; shrink the window
            3. Return the global maximum sum
        """

        def fn1(goal):
            if goal < 0: return 0
            n = len(nums)
            total = 0
            start, gcount = 0,0
            for end in range(n):
                total += nums[end]
                while total > goal:
                    total -= nums[start]
                    start += 1

                subarray_count = (end - start + 1)
                gcount += subarray_count

            return gcount

        return fn1(goal) - fn1(goal-1)