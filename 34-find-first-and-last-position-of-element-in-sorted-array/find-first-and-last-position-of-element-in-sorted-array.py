class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def lower_bound(nums, target: int) -> int:
            low = 0
            high = len(nums) - 1

            while low <= high:
                mid = (low + (high - low) // 2)
                if nums[mid] >= target:
                    high = mid - 1
                else:
                    low = mid + 1

            return low if low < len(nums) and nums[low] == target else -1

        def upper_bound(nums, target: int) -> int:
            low = 0
            high = len(nums) - 1

            while low <= high:
                mid = (low + (high - low) // 2)
                if nums[mid] <= target:
                    low  = mid + 1
                else:
                    high = mid - 1

            # Check if the element at index low - 1 is the target
            if low == 0 or nums[low - 1] != target:
                return -1
            else:
                return low - 1

        # search the target element using the lower bound and upper bound funcs
        low_index = lower_bound(nums, target)
        high_index = upper_bound(nums, target)

        # return the ranges
        return [low_index, high_index]
