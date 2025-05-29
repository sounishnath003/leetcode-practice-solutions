# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        """
        # algorithm:
        we should apply the good old two pointer technique
        fast, slow pointers when they met,
        start the loop after the reset of any one pointer and let them met again
        return the meeting point either of pointers :-)
        """

        # base case: if no head
        if not head:
            return None
        
        # create two pointers slow and fast and assign head
        slow = fast = head
        # while fast exists increment the fast by 2x and slow by x
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            # if slow and fast met?
            if slow == fast:
                # break from the loop
                break

        # check if fast still not null, if it is null
        # i.e: no cycle or meeting found
        if not fast or not fast.next:
            return None
        
        # reset one (slow) pointers to head again
        slow = head
        # continue the process at x speed
        while slow != fast:
            slow = slow.next
            fast = fast.next
        
        # you gotta the point
        return slow