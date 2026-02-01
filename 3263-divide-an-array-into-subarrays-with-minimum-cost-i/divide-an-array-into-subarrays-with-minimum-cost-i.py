class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        n = len(nums)
        # 0th index element is always included...
        # we do not have any choices to explore here? no dependency
        # split into K segments
        # no future constraints...

        cost = nums[0] # you are always including the 0th index elemnt
        # find two minimums which gives you smaller sums
        INF = 10**20
        min1, min2 = INF, INF
        for i in range(1,n):
            e = nums[i]
            if min1 > e:
                min2,min1=min1,e
            elif e >= min1 and min2 > e:
                min2=e
        print(f"{min1=}, {min2=}")
        return cost + min1 + min2