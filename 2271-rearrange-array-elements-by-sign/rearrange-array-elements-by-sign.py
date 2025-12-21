class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        if n < 2: return nums

        pos_index = 0
        neg_index = 1

        ans = [0] * n
        # iterate over the nums array
        for i in range(n):
            if nums[i] < 0: 
                ans[neg_index] = nums[i]
                # move the neg index by 2
                neg_index += 2
            else:
                ans[pos_index] = nums[i]
                # move pos index by +2
                pos_index += 2

        return ans 