class Solution:
    def oddEvenList(self, root: Optional[ListNode]) -> Optional[ListNode]:
        if not root:
            return None

        # This function splits nodes by *position*, not value:
        # 1st, 3rd, 5th, ... then 2nd, 4th, 6th, ...
        oddD, evenD = ListNode(), ListNode()
        odd, even = oddD, evenD
        is_odd = True

        while root:
            if is_odd:
                odd.next = root
                odd = odd.next
            else:
                even.next = root
                even = even.next
            root = root.next
            is_odd = not is_odd

        # End both lists
        even.next = None
        # Connect end of odd list to start of even list
        odd.next = evenD.next

        return oddD.next