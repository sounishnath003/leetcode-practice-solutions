class Solution:
    def findDuplicate(self, arr: List[int]) -> int:
        """ apply the cyclic sorting """
        slow=arr[0]
        fast=arr[0]

        while True:
            slow=arr[slow]
            fast=arr[arr[fast]]
            if slow == fast:
                break

        fast=arr[0]
        while slow!=fast:
            slow=arr[slow]
            fast=arr[fast]

        return slow