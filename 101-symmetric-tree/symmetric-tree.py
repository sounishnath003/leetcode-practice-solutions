class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def is_symmetric_tree(root1, root2):
            """my subtrees left and right values and tree must be valid"""
            if not root1 and not root2:
                return True
            if not root1 or not root2:
                return False
            return (
                root1.val == root2.val
                and is_symmetric_tree(root1.left, root2.right)
                and is_symmetric_tree(root1.right, root2.left)
            )

        return is_symmetric_tree(root, root)
