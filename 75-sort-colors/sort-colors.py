class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        
        you could have 3 pointers, 
        low, mid, high
        low++ if mid is at 0 + swap(low, mid)
        mid ++ if mid == 1
        high-- mid is at 2
        """

        low=0
        mid=0
        high=len(nums)-1

        while mid <= high:
            if nums[mid] == 0:
                nums[low],nums[mid]=nums[mid],nums[low]
                low+=1
                mid +=1
            elif nums[mid] == 2:
                nums[mid],nums[high]=nums[high],nums[mid]
                high-=1
            else:
                mid +=1