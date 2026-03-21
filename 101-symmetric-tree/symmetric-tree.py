class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def fn(root1: TreeNode, root2: TreeNode) -> bool:
            if not root1 and not root2:
                return True

            if (not root1 and root2) or (root1 and not root2 or root1.val != root2.val):
                return False

            return fn(root1.left, root2.right) and fn(root1.right, root2.left)

        return fn(root, root)