class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        """minimum number of days to make M bouquets"""
        n = len(bloomDay)
        low = 1
        high = max(bloomDay) # the maximum day is the last day if i can make bouquets
        # when you do not have sufficient amount of flowers to make M bouquets!
        if (n < m*k): return -1
        
        # can make function answer if i can make M bouquets
        def can_make(day):
            flowers = 0
            no_of_bouquets = 0
            for bday in bloomDay:
                if bday <= day:
                    flowers += 1
                else:
                    no_of_bouquets += (flowers // k)
                    flowers = 0
            # left over elements
            no_of_bouquets += (flowers // k)
            # to make m bouquets each having K flowers
            # hence you need to have m * k flowers in total
            return no_of_bouquets >= m
        
        ans = high
        while low <= high:
            mid = (low + high) // 2 # minimum atleast day
            if can_make(mid):
                ans = mid
                high = mid - 1
            else:
                low = mid + 1

        return ans
