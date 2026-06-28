class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        # ------------------
        # LC: 494
        # https://leetcode.com/problems/target-sum/
        # ------------------
        """returns # of ways to achieve target to assign + / - to reach
        Thoughts:
        1. Question asked to check if target is acieveable by assign + or - to alternative numbers
        2. essentially -> +a-b+c-d+e-f -> (a+c+e) + (-b-d-f) -> S1 + S2 = total_sum
        3. so, we can find new target where -> (total_sum - target) // 2
        4. consider s2 as target...
        5. boils down to -> count # subsets with target (total_sum-target) // 2
        """
        def fn(i:int, target:int, dp:dict[tuple[int,int], int]) -> int:
            if target == 0: return 1
            # if i = 0, if target is 0 already and nums[0] is also 0 -> 2 subsets
            # if i = 0, if nums[0] == target or target == 0 already, you will get 1
            if i == 0:
                if nums[0] == 0 and target == 0:
                    return 2
                if target == 0 or nums[0] == target:
                    return 1
                return 0
            if i == 0: return 1 if target == nums[0] else 0
            if (i,target) in dp:
                return dp[(i,target)]
            # you have choices -> pick or not pick
            op1 = fn(i-1,target,dp) # skipped
            op2 = fn(i-1,target-nums[i],dp) if target >= nums[i] else 0
            dp[(i,target)] = op1 + op2
            # return the state
            return dp[(i,target)]

        n = len(nums)
        # preprocessing
        total_sum = sum(nums)
        # feasibility check:
        if (total_sum - target) < 0 or (total_sum - target) % 2 == 1:
            return 0

        target = (total_sum - target) // 2 # new target
        dp = [[0] * (target+1) for _ in range(n)] # n x target+1
        # base cases:
        if nums[0] == 0:
            dp[0][0] = 2
        else:
            dp[0][0] = 1
            if nums[0] <= target:
                dp[0][nums[0]] = 1
        # iterate an solve the sustems
        for i in range(1,n):
            for t in range(target+1):
                op1 = dp[i-1][t]
                op2 = dp[i-1][t-nums[i]] if t >= nums[i] else 0
                dp[i][t] = op1 + op2

        return dp[n-1][target]
