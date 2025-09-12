class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        """simply apply the 2 pointer technique
        tortoise and hare or slow or fast pointers"""

        slow=nums[0]
        fast=nums[0]

        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break

        fast=nums[0]
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]

        return slow