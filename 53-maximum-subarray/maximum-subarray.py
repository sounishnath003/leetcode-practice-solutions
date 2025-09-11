class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # find the subarray with largest sum
        gmax = nums[0]
        total = 0
        # iterate over the array
        for end, num in enumerate(nums):
            # count the prefix sum of the elements
            total += num
            # in case my current ongoing sum
            # becomes negetive, i will start a new window from next position
            if total < num:
                total = num
            # update gmax:
            # the total only if the total is bigger than gmax
            if total > gmax:
                gmax = total

        return gmax