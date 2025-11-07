class Solution:
    def minCostClimbingStairs(self, costs: List[int]) -> int:
        """returns the mini cost to escape the arrays"""
        n = len(costs)

        dp = {}
        def fn(n:int) -> int:
            if n < 2: return 0
            if n in dp: return dp[n]
            dp[n] = min(
                    costs[n-1] + fn(n-1),
                    costs[n-2] + fn(n-2)
            )
            return dp[n]

        return fn(n)