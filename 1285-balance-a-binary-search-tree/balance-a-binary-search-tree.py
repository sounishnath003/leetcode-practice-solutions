class Solution:
    def balanceBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        """convert the binary search tree into balance binary search tree"""
        nodes = []
        def inorder_fn(root: TreeNode):
            nonlocal nodes
            if not root:
                return None
            inorder_fn(root.left)
            nodes.append(root.val)
            inorder_fn(root.right)

        # call: inorder fn
        inorder_fn(root)

        def construct_bst_fn(low:int, high:int) -> TreeNode:
            if low > high:
                return None

            mid = (low + high) // 2
            root = TreeNode(nodes[mid])
            root.left = construct_bst_fn(low,mid-1)
            root.right = construct_bst_fn(mid+1,high)

            return root

        root = construct_bst_fn(low=0, high=len(nodes)-1)
        return root
