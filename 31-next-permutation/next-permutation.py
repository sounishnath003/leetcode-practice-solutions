import typing

# LC 31: https://leetcode.com/problems/next-permutation/
class Solution:
    def nextPermutation(self, nums: typing.List[int]) -> typing.List[int]:
        """
        Do not return anything, modify nums in-memory  instead.
        """
        def swap(nums, i: int, j: int) -> None:
            """utility method: swap the position (i,j) for a given list"""
            # use python magic in one-line replace.
            nums[i], nums[j] = nums[j], nums[i]

        def reverse(nums, start:int, end:int) -> None:
            """utility method: returns a given list in range (start, end)"""
            while start < end:
                swap(nums, start, end)
                start += 1
                end -= 1

        # get the length of the arr
        n = len(nums)
        # find a pivot element, where nums[i+1] > nums[i]
        first_index = None

        for i in range(n-2, -1, -1):
            if nums[i+1] > nums[i]:
                first_index = i
                break

        # if still i could not find any first index where nums[i+1] > nums[i]
        # it is already sorted in DESC; in that case my answer'd be reverse of nums itself
        # e.g. 4321 -> 1234: as mentioned in question.
        if first_index is None:
            reverse(nums, 0, n-1)
            return # void return
        
        # find the second index; i.e. nums[index] > nums[first_index]
        second_index = n-1
        for i in range(n-1, first_index, -1):
            if nums[i] > nums[first_index]:
                second_index = i
                break
        # now, as you got the two pivotal element you just have to swap them
        # 1342 -> fi: 3, si: 4 -> 1432 -> 1423
        swap(nums, first_index, second_index)
        # then, you have to just reverse the sequence from first_index + 1 .... end
        reverse(nums, first_index + 1, n-1)
