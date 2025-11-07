class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        def path_sum(root: Optional[TreeNode], target_sum:int) -> int:
            """returns the number of paths that sums up the target sum"""
            path_sums = defaultdict(int) # sum -> count
            path_sums[0] = 1
            paths = 0

            def dfs(root: TreeNode, total:int) -> int:
                nonlocal path_sums, paths
                if not root: return 0
                
                total += root.val
                paths += path_sums[total - target_sum]
                path_sums[total] += 1

                if root.left: dfs(root.left, total)
                if root.right: dfs(root.right, total)

                path_sums[total] -= 1

            dfs(root, 0)

            return paths

        return path_sum(root, targetSum)