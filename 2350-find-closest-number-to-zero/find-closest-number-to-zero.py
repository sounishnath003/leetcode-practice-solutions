class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        # 1: closet is the 0th element
        closet = nums[0]
        # 2. check if any other element is more closet than existing
        for num in nums:
            closet = num if abs(num) < abs(closet) else closet
        # 3. check if closet has any +/- versions
        if closet < 0 and abs(closet) in nums: closet = abs(closet)
        # 4. return closet
        return closet