from typing import Optional

MAX = float('inf')
MIN = -MAX

class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        def f(root): # returns [min_val, max_val, is_bst, sum_of_bst]
            if not root:
                return [MAX, MIN, True, 0]

            left_rec = f(root.left)
            right_rec = f(root.right)

            is_bst = False
            current_sum = 0

            if left_rec[2] and right_rec[2] and root.val > left_rec[1] and root.val < right_rec[0]:
                is_bst = True
                current_sum = root.val + left_rec[3] + right_rec[3]
                self.ans = max(self.ans, current_sum)

            min_val = min(root.val, left_rec[0])
            max_val = max(root.val, right_rec[1])

            return [min_val, max_val, is_bst, current_sum if is_bst else 0]

        f(root)
        return self.ans