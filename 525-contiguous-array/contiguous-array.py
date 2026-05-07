class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        """
        simply find prefix sum += -1 if 0 else +1
        check if prefix sum in mapp: calc. window (end - mapp[prefix_sum])
        update the global gmax and return
        """
        n, gmax = len(nums),0
        mapp = Counter()
        mapp[0] = -1
        ps = 0

        for end in range(n):
            ps += 1 if nums[end] == 1 else -1
            if ps in mapp:
                gmax = max(gmax, end - mapp[ps])
            else:
                mapp[ps] = end    

        return gmax