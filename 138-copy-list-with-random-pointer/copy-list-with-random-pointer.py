class Solution:
    def copyRandomList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root

        # 1. Insert copied nodes right after originals
        curr = root
        while curr:
            original_next = curr.next
            curr.next = Node(curr.val)
            curr.next.next = original_next
            curr = original_next

        # 2. Assign random pointers
        curr = root
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next

        # 3. Separate the two lists
        dummy = Node(0)
        copy_curr = dummy
        curr = root

        while curr:
            copy_curr.next = curr.next
            copy_curr = copy_curr.next

            curr.next = curr.next.next
            curr = curr.next

        return dummy.next