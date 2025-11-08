class Solution:
    def uniquePaths(self, R: int, C: int) -> int:
        """returns # of ways to reach to the bottom right corner"""
        dp = [[0] * C for _ in range(R)]

        for col in range(C): dp[0][col] = 1
        for row in range(R): dp[row][0] = 1

        for row in range(1, R): 
            for col in range(1, C): 
                dp[row][col] = dp[row-1][col] + dp[row][col-1]

        return dp[R-1][C-1]
    
    def uniq_paths(R:int, C:int) -> int:
        """returns # of ways to reach to the bottom right corner"""
        dp = {}
        def fn(r:int, c:int) -> int:
            nonlocal dp

            if not(0 <= r < R and 0 <= c < C): return 0

            if r==R-1 and c==C-1: return 1
            if (r,c) in dp: return dp[(r,c)]
            op1 = fn(r,c+1)
            op2 = fn(r+1,c)

            dp[(r,c)] = op1+op2
            return dp[(r,c)]

        fn(0,0)

        return dp[(0,0)]
