class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        # from functools import reduce
        # return reduce(lambda a,b: a^b, nums, 0)
        low=0
        high=len(nums)-1

        if len(nums)==1: return nums[0]
        if nums[0]!=nums[1]: return nums[0]
        if nums[-1]!=nums[-2]: return nums[-1]

        while low<=high:
            mid=(low+high)//2
            if nums[mid]!=nums[mid-1] and nums[mid]!=nums[mid+1]: return nums[mid]
            elif nums[mid]==nums[mid-1]:
                leftcount=(mid-low+1)
                if leftcount%2==0: low=mid+1
                else: high=mid-2
            else:
                rightcount=(high-mid+1)
                if rightcount%2==0: high=mid-1
                else: low=mid+2

        return nums[low]
