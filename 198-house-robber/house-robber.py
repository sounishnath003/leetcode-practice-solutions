class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        dp = {}

        def fn(i:int) -> int:
            nonlocal dp
            if i < 0: return 0
            if i in dp: return dp[i]
            # you have two options
            op1 = fn(i-1) # skip the house donot rob
            op2 = nums[i] + fn(i-2) # rob the house, and goto i-2

            dp[i] = max(op1, op2)
            return dp[i]

        fn(n-1)
        return dp[n-1]
