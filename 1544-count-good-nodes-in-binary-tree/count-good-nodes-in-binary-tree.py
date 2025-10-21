class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(root:TreeNode, maxx:int) -> int:
            if not root: return 0
            goods_left = dfs(root.left, max(maxx, root.val))
            goods_right = dfs(root.right, max(maxx, root.val))
            return goods_left + goods_right + (1 if root.val >= maxx else 0)

        return dfs(root, float('-inf'))