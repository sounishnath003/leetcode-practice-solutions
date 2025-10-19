class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        # we could have 2 two pointers fast and slow
        # slow goes by 1 node
        # fast goes by 2 nodes
        if not head:
            return False
            
        slow = head
        fast = head
        # try until fast and fast.next has values   
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            # while moving, if the pointers references same node
            if slow == fast:
                return True

        return False
        
        