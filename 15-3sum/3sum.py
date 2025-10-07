class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        results = []
        # sort the input nums
        nums.sort()
        # iterate over the nums array and pick one element and apply two sum
        for i in range(len(nums)):
            # skip ae duplicates
            if i > 0 and nums[i] == nums[i-1]: continue
            ae = nums[i]
            # two sum
            i = i + 1
            j = len(nums) - 1
            while i < j:
                be,ce=nums[i],nums[j]
                total = ae + be + ce
                if total == 0:
                    results.append([ae,be,ce])
                    i+=1
                    j-=1
                    # skip duplicates
                    while i < j and nums[i]==nums[i-1]: i+=1
                    while i < j and nums[j]==nums[j+1]: j-=1
                elif total > 0:
                    j-=1
                else:
                    i+=1

        return results