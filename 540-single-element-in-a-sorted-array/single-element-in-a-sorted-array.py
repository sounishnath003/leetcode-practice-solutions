class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        from functools import reduce
        return reduce(lambda a,b: a^b, nums, 0)