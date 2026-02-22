class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # TC: O(N); SC: O(1) # no space required!
        if head is None or head.next is None: return head
        dummy, curr = ListNode(), head
        res = dummy
        while curr and curr.next:
            next_node = curr.next
            curr.next = next_node.next
            next_node.next = curr
            res.next = next_node
            res, curr = curr, curr.next
            
        return dummy.next
            
    def swapPairs2(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # TC: O(N); SC: (N) cux i am using recursive faith call stack 
        if head is None or head.next is None:
            return head
        # recursive faith        
        rhead = self.swapPairs(head.next.next)
        # my work
        t = head.next
        t.next = head
        head.next = rhead

