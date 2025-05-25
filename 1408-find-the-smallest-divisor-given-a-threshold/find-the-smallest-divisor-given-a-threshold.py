class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        low=1
        high=max(nums)
        ans=high

        def is_possible(mid):
            ans = 0
            for el in nums:
                ans += math.ceil(el / mid)
            return ans <= threshold
        
        while low <= high:
            mid=(low + high) // 2
            if is_possible(mid):
                ans=mid
                high=mid-1
            else:
                low=mid+1

        return ans