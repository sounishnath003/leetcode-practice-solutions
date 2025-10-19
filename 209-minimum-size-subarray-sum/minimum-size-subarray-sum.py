class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        start = 0
        gmin = float("inf")
        prefix_sum = 0

        # Iterate over the nums array and check it
        for end, num in enumerate(nums):
            prefix_sum += num
            # if prefix sum is bigger than the target when start looking at this
            while prefix_sum >= target:
                # Window length calculation
                window_length = end - start + 1
                # calculate the gmin length update
                gmin = min(gmin, window_length)
                # update the prefix sum substract from nums[start]
                prefix_sum = prefix_sum - nums[start]
                # increment the start pointer ...
                start += 1


        return 0 if gmin == float("inf") else gmin
