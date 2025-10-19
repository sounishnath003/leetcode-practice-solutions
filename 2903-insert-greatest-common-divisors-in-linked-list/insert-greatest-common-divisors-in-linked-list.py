class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        """
        The idea is to traverse the linked list, and between every two nodes,
        insert a new node whose value is the gcd of their values.
        The implementation should NOT skip nodes by advancing both prev and curr
        pointers at the end of each loop, as that would miss some insertions.
        """

        if not head or not head.next:
            return head

        curr = head

        while curr and curr.next:
            prev = curr
            curr = curr.next
            gcd_node = ListNode(math.gcd(prev.val, curr.val))
            prev.next = gcd_node
            gcd_node.next = curr
            prev = gcd_node

        return head