class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        @lru_cache(None)
        def f(r,c):
            if r < 1 or c < 1:
                return 0

            if r==1 and c==1:
                return 1

            return f(r-1,c)+f(r,c-1)

        return f(m,n)