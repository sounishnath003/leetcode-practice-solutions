class Solution:
    def minOperations(self, nums: list[int]) -> int:
        operations = 0
        for i in range(1,len(nums)):
            prev,curr = nums[i-1],nums[i]
            if prev > curr:
                operations += (prev - curr)

        return operations