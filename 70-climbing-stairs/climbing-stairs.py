class Solution:
    def climbStairs(self, n: int) -> int:
        dp={}
        def f(n):
            nonlocal dp

            if n in dp:
                return dp[n]

            if n <=0:
                dp[n] = 1 if n == 0 else 0
                return dp[n]
            
            dp[n] = f(n-1) + f(n-2)
            return dp[n]
        
        return f(n)