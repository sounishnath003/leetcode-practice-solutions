class Solution:
    def minRemoval(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()

        gmax = 0
        right = 0
        # minimum removals means: maximum keeping
        for left in range(n):
            while right < n and nums[right] <= nums[left] * k:
                right += 1
            gmax = max(gmax, right - left)

        # gmax says: how many elements i can keep (instead of removing on basis of condn)
        return n - gmax # says: minimum removal required