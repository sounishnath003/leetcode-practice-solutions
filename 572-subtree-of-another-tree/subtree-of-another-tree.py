class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def is_same_tree(root, subRoot):
            if not root and not subRoot: return True
            if not root or not subRoot: return False
            return root.val == subRoot.val \
                and is_same_tree(root.left, subRoot.left) \
                and is_same_tree(root.right, subRoot.right)

        if not root: return False
        if not subRoot: return False
        if root.val == subRoot.val and is_same_tree(root, subRoot): return True
        return self.isSubtree(root.left, subRoot) \
               or self.isSubtree(root.right, subRoot)
