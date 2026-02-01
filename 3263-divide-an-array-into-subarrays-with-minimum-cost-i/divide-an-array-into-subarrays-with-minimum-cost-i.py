from functools import lru_cache

class Solution:
    def minimumCost(self, nums):
        n = len(nums)

        @lru_cache(None)
        def dfs(i, k):
            # need k subarrays from nums[i:]
            if k == 0:
                return 0 if i==n else float('inf')

            if i+k > n:
                return float('inf')

            res = float('inf')

            # choose end of current subarray
            for end in range(i, n - k + 1):
                res = min(res, nums[i] + dfs(end + 1, k - 1))

            return res

        return dfs(0, 3)
