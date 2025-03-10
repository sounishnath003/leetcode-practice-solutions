class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0

        n = len(nums)
        dp = [1] * n

        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)

        return max(dp)
    
    def lengthOfLIS2(self, nums: List[int]) -> int:
        # subsequence method pick or not pick
        def func(nums, i, prev_index):
            if i == len(nums):
                return 0

            np=func(nums, i+1, prev_index)
            pick=float("-inf")
            if (prev_index == -1 or nums[i] > nums[prev_index]):
                pick=1+func(nums,i+1,i)

            return max(np,pick)

        return func(nums,0,-1)