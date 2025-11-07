class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        gmax = float("-inf")

        def dfs(root: TreeNode):
            nonlocal gmax
            if not root: return 0
            # faith
            left_max = dfs(root.left)
            right_max = dfs(root.right)

            # my work
            single_side = max(left_max, right_max) + root.val
            other_option = max(single_side, left_max + right_max + root.val)
            gmax = max(gmax, other_option)

            return max(0, single_side)

        dfs(root)

        return gmax