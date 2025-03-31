MAX=float('inf')

class Solution:
    def numSquares(self, n: int) -> int:
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