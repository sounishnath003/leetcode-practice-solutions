class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def validate_fn(root: TreeNode, lower_bound: int, upper_bound:int) -> bool:
            if not root: return True
            if root and root.val <= lower_bound or root.val >= upper_bound: return False
            return validate_fn(root.left, lower_bound, root.val) and validate_fn(root.right, root.val, upper_bound)

        return validate_fn(root, float("-inf"), float("inf"))
