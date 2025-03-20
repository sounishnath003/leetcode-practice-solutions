# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    max_depth=0
    result=None
    def subtreeWithAllDeepest(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def find_depth(root, depth):
            if not root:
                return depth

            rlh=find_depth(root.left, depth+1)
            rrh=find_depth(root.right, depth+1)

            if rlh == rrh:
                self.max_depth=max(self.max_depth, rlh)
                if rlh == self.max_depth:
                    self.result=root

            return max(rlh, rrh)

        find_depth(root, 0)

        return self.result

        