class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        # get the length of the nums arr
        n=len(nums)
        # count the frequency of the elems
        freq=Counter(nums) # such as: {1: 2, 2: 1, 3: 1}
        # return if any k has v > 1 return True
        return any([ True  if x >= 2 else False for x in freq.values()])