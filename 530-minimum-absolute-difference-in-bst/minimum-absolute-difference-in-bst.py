class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        gmin=float("inf")
        prev_node: TreeNode = None

        def inorder_fn(root: TreeNode) -> None:
            nonlocal gmin, prev_node
            if not root: return None
            # inorder traversal
            inorder_fn(root.left)
            if prev_node: gmin = min(gmin, root.val - prev_node.val)
            prev_node = root
            inorder_fn(root.right)

        inorder_fn(root)
        return gmin