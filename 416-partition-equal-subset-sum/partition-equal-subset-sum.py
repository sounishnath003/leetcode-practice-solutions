class Solution:
    # LC: 416
    def canPartition(self, nums: List[int]) -> bool:
        # get the total array sum
        total = sum(nums)
        # if the total is not dividable into 2 parts...
        # it is odd. so return false
        if total % 2 != 0: return False
        # as we need to divide the into exactly 2 subsets which has equal sum
        target_sum = total // 2

        n = len(nums)
        dp = [[False] * (target_sum + 1) for _ in range(n)]

        # base case
        for t in range(target_sum + 1):
            dp[0][t] = nums[0] == t

        # other case
        for i in range(1, n):
            for t in range(target_sum + 1):
                op1 = dp[i - 1][t]
                op2 = dp[i - 1][t - nums[i]] if t >= nums[i] else False

                dp[i][t] = op1 or op2

        return dp[n-1][target_sum]