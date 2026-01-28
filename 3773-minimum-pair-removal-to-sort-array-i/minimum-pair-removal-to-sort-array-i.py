class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        operations = 0
        def is_sorted(nums):
            return all(nums[i-1] <= nums[i] for i in range(1, len(nums)))

        def min_pair_sum_fn():
            index = -1
            msum = float("inf")

            for i in range(len(nums) - 1):
                if msum > nums[i] + nums[i+1]:
                    msum = nums[i] + nums[i+1]
                    index = i

            return index

        while not is_sorted(nums):
            index = min_pair_sum_fn()
            nums[index] = nums[index] + nums[index+1]
            nums.pop(index+1)

            operations += 1

        return operations