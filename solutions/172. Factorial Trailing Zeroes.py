import math
​
class Solution:
    def trailingZeroes(self, n: int) -> int:
        if n < 5:
            return 0
        ans = 0
        while n > 4:
            ans+=int(n/5)
            n = n / 5
            
        return ans
