class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        def dfs(root: TreeNode, cursum: int) -> bool:
            nonlocal targetSum
            if not root: return False
            if not root.left and not root.right: return cursum + root.val == targetSum
            return dfs(root.left, root.val+cursum) or dfs(root.right, root.val+cursum)

        return dfs(root, 0)