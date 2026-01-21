class Solution:
    def bstToGst(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        prefix_sum = 0
        def dfs_fn(root: TreeNode):
            nonlocal prefix_sum
            if not root:
                return
            
            # reverse inorder
            dfs_fn(root.right)
            # my work
            prefix_sum += root.val
            root.val = prefix_sum
            dfs_fn(root.left)
            
        dfs_fn(root)
        
        return root