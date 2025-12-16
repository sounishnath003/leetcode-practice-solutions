class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        total=[0]
        def dfs_fn(root, digit:int):
            nonlocal total
            if not root: return
            if root and not root.left and not root.right:
                total.append(digit*10 + root.val)
                return

            dfs_fn(root.left, digit * 10 + root.val)
            dfs_fn(root.right, digit * 10 + root.val)

        dfs_fn(root,0)

        return sum(total)