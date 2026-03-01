class Solution:
    def rotateRight(self, root: Optional[ListNode], K: int) -> Optional[ListNode]:
        if not root or not root.next or K == 0:
            return root

        # Step 1: Find length and tail
        length = 1
        tail = root
        while tail.next:
            tail = tail.next
            length += 1

        # Step 2: Reduce K
        K %= length
        if K == 0:
            return root

        # Step 3: Make it circular
        tail.next = root

        # Step 4: Find new tail (length - K - 1 steps)
        steps = length - K
        new_tail = root
        for _ in range(steps - 1):
            new_tail = new_tail.next

        # Step 5: Break circle
        new_head = new_tail.next
        new_tail.next = None

        return new_head