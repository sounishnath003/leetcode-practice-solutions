# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        balanced=True

        def height_fn(root:TreeNode):
            nonlocal balanced
            if not root: return 0
            # faith
            left = height_fn(root.left)
            right = height_fn(root.right)

            # my work
            diff = abs(left - right)
            if diff > 1: balanced=False

            return 1 + max(left, right)

        height_fn(root)
        return balanced