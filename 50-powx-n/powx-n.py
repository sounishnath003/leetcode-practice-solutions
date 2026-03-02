class Solution:
    def myPow(self, x: float, n: int) -> float:
        def fn(x, n):
            if n <= 0:
                return 1.0
            if n % 2 == 0:
                X = fn(x, n // 2)
                return X * X
            else:
                return x * fn(x, n - 1)
            
        if n >= 0:
            return fn(x, n)
        else:
            return 1.0 / fn(x, -n)