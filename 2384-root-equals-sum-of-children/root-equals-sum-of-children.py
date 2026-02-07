# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def checkTree(self, root: Optional[TreeNode]) -> bool:
        if root.left is None or root.right is None:
            return True

        total = 0
        if root.left:
            total += root.left.val
        if root.right:
            total += root.right.val

        if root.val != total:
            return False

        lh = self.checkTree(root.left)
        rh = self.checkTree(root.right)
        if lh == False or rh == False:
            return False

        return True