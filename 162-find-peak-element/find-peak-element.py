class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        n = len(nums)

        if n == 1 or nums[0] > nums[1]: return 0
        if n-2 >= 0 and nums[n-1] > nums[n-2]: return n-1

        low, high = 1,n-1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid-1] < nums[mid] and nums[mid] > nums[mid+1]:
                return mid
            elif nums[mid-1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        return -1