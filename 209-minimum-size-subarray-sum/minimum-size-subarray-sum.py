class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        """find the shorter window length elem, which matches or more than target"""
        # get length
        n=len(nums)
        # result, keeping the window length to be the array length only
        # we need to minmize it only
        result=float('inf')
        # we need to apply the sliding window technique only
        # slide the window and get the answer
        start=0
        # prefix sum
        prefix_sum=0
        # iterate over the elem in arr
        for end in range(n):
            prefix_sum += nums[end]
            while prefix_sum >= target:
                window_length=end-start+1
                result=min(result, window_length)
                prefix_sum=prefix_sum - nums[start]
                start +=1
        return 0 if result == float('inf') else result