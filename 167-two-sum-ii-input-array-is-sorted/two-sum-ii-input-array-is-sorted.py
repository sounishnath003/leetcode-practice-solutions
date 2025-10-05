class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        left = 0
        right = len(nums) - 1

        while left <= right:
            a = nums[left]
            b = nums[right]
            if (a+b) > target:
                right -= 1
            elif (a+b) < target:
                left += 1
            else:
                return [left + 1, right + 1]

        return []