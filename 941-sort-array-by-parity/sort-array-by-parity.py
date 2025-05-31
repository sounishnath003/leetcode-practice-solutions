class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        j=0
        for i, e in enumerate(nums):
            if e % 2 == 1:
                continue
            # but if it is even then
            nums[i],nums[j]=nums[j],nums[i]
            j+=1

        return nums
    
    def bruteforce(self, nums: List[int]) -> List[int]:
        """because of python magic"""
        return [ x for x in nums if x % 2 == 0 ] + [ x for x in nums if x % 2 == 1 ]