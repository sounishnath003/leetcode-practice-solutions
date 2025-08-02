
class Solution:
    def sortArrayByParity(self, nums: list[int]) -> list[int]:
        """we need to place all evens first part, then all the odds"""
        left=0
        right=len(nums) - 1

        def is_even(n:int):
            return n%2==0

        while left < right:
            left_elem=nums[left]
            right_elem=nums[right]

            if is_even(left_elem):
                # nothing to do, just move your left pointer
                left +=1
            elif not is_even(right_elem):
                # nothing to do, just move your right pointer
                right -= 1
            else:
                # swap the positions
                nums[left],nums[right]=right_elem,left_elem
                left +=1
                right -=1

        return nums