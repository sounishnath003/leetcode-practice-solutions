# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        def dfs_fn(root, cursum):
            if not root: return 0
            cursum = 2*cursum+root.val
            if not root.left and not root.right: return cursum
            return dfs_fn(root.left, cursum) + dfs_fn(root.right, cursum)

        return dfs_fn(root,0)