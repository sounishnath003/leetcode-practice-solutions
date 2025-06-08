MOD = int(1e9+7)

class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        # First compute the total sum of the tree
        def getsum(root):
            if not root:
                return 0
            return root.val + getsum(root.left) + getsum(root.right)

        tree_sum = getsum(root)
        self.max_prod = 0  # Keep track of the maximum product

        # DFS to calculate subtree sums and compute product
        def dfs(root):
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            subtotal = root.val + left + right
            # Try splitting at this node
            self.max_prod = max(self.max_prod, subtotal * (tree_sum - subtotal))
            return subtotal

        dfs(root)
        return self.max_prod % MOD
