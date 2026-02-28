class Solution:
    def sortList(self, root: Optional[ListNode]) -> Optional[ListNode]:
        if not root or not root.next:
            return root

        def find_middle(root: ListNode) -> ListNode:
            slow, fast = root, root.next
            while fast and fast.next:
                slow, fast = slow.next, fast.next.next
            return slow

        def merge(h1: ListNode, h2: ListNode):
            resD = ListNode()
            res = resD

            while h1 and h2:
                if h1.val <= h2.val:
                    res.next = h1
                    h1 = h1.next
                else:
                    res.next = h2
                    h2 = h2.next

                res = res.next

            res.next = h1 if h1 else h2
            return resD.next


        # get the middle node
        middle = find_middle(root)
        if not middle.next:
            return root
        middle_next = middle.next
        middle.next = None

        head1 = self.sortList(root)
        head2 = self.sortList(middle_next)

        return merge(head1, head2)
        