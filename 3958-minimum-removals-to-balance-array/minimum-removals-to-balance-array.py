class Solution:
    def minRemoval(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()

        gmax = 0
        start = 0
        # minimum removals means: maximum keeping
        for end in range(n):
            while nums[end] > nums[start] * k:
                start += 1
            gmax = max(gmax, end - start + 1)

        # gmax says: how many elements i can keep (instead of removing on basis of condn)
        return n - gmax # says: minimum removal required