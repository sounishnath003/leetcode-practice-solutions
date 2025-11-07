class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root: return []
        prefix_sums = defaultdict(list)
        prefix_sums[0] = []

        def dfs_fn(root: Optional[TreeNode], cursum:int, paths:List[int]) -> None:
            if root.left: dfs_fn(root.left, cursum+root.val, paths + [root.val])
            if root.right: dfs_fn(root.right, cursum+root.val, paths + [root.val])
            # check if leaf node?
            if not root.left and not root.right:
                if cursum+root.val == targetSum:
                    prefix_sums[0].append(paths + [root.val])

        dfs_fn(root, 0, [])
        return prefix_sums[0]