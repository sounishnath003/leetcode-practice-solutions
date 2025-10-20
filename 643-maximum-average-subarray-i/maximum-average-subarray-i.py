class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        start = 0
        gmavg = float("-inf")

        prefix_sum = 0

        for end, num in enumerate(nums):
            prefix_sum += num
            window = (end - start + 1)
            if window == k:
                current_average = prefix_sum / k
                gmavg = max(current_average, gmavg)
                # substract the nums[start] from prefix sum
                prefix_sum -= nums[start]
                # increment the start pointers
                start += 1

        return gmavg