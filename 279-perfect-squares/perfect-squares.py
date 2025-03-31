MAX=float("inf")
class Solution:
    def numSquares(self, n: int) -> int:
        perfect_squares = []
        i = 1
        while i * i <= n:
            perfect_squares.append(i * i)
            i += 1

        dp = [float('inf')] * (n + 1)
        dp[0] = 0

        for square in perfect_squares:
            for j in range(square, n + 1):
                dp[j] = min(dp[j], dp[j - square] + 1)

        return dp[n]
        
    def numSquares2(self, n: int) -> int:
        def f(ps,i,n,dp=None):
            if dp is None:
                dp={}
            if n == 0:
                return 0
            if i == len(ps) or n < 0:
                return MAX
            
            if (i,n) in dp:
                return dp[(i,n)]
                
            notpick=f(ps,i+1,n,dp)
            pick=1+f(ps,i,n-ps[i],dp)
            dp[(i,n)]= min(notpick,pick)
            return dp[(i,n)]
        perfect_squares = list(map(lambda x: x**2, list(range(n,0,-1))))
        print(perfect_squares)
        return f(perfect_squares,0,n)
