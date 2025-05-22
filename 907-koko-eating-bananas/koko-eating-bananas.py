import math

class Solution:
    def minEatingSpeed(self, piles: list[int], h: int) -> int:
        """
        koko wants to finish banana at K speed, K must be minimum
        within H hours
        -> binary search
        """
        low = 1
        high = max(piles)
        ans = high

        def possible_to_finish(banana_speed, hour_limit):
            # speed at koko should be eating is banana_speed
            res = 0
            for pile in piles:
                # Use math.ceil to correctly calculate hours needed for each pile
                res += math.ceil(pile / banana_speed)
                if res > hour_limit:
                    return False
            return True

        # we will search between low to high range
        while low <= high:
            # we will try to eat mid banana
            atleast_banana = (low + high) // 2 # Integer division for mid calculation
            # check if koko can finish at least banana within H hours
            # if he can, we will try to minimize the search space by making high=mid-1
            if possible_to_finish(atleast_banana, h):
                ans = atleast_banana # Update ans directly, no need for min with itself if we're narrowing the search space
                high = atleast_banana - 1
            else:
                low = atleast_banana + 1

        return ans