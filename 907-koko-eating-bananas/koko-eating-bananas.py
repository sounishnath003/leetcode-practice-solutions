import math
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # we can apply binary search
        # as we need to minimize the maximum
        if len(piles) < 1:
            return max(piles)
        low = 1
        high = max(piles)
        ans = high

        def possible(banana):
            res=0
            for pile in piles:
                res += math.ceil(pile / banana)
                if res > h:
                    return False
            return True

        while low <= high:
            mid = math.ceil((low + high) / 2)
            if possible(mid):
                ans=mid
                high=mid-1
            else:
                low=mid+1

        return ans