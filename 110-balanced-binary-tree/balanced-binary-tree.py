class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def height_fn(root:TreeNode):
            # nonlocal balanced
            if not root: return 0
            # faith
            left = height_fn(root.left)
            right = height_fn(root.right)

            # my work
            diff = abs(left - right)
            if left == -1 or right == -1 or diff > 1: return -1

            return 1 + max(left, right)

        return False if height_fn(root) == -1 else True
        # return balanced