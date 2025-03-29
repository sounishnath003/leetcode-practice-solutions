class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        n=len(nums)
        gmax=0
        count=0

        for i in range(n):
            e=nums[i]
            if e != 1:
                gmax=max(gmax, count)
                count=0
            else:
                count+=1

        gmax=max(gmax,count)
        return gmax