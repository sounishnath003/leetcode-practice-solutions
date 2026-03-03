class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res, sol = [], []
        nums.sort()

        def fn(i: int):
            res.append(sol[:])
            for j in range(i, len(nums)):
                # “At each level, only allow the first occurrence of a duplicate number.”
                if j > i and nums[j] == nums[j-1]:
                    continue
                sol.append(nums[j])            
                fn(j+1)
                sol.pop()

        fn(i=0)
        return res