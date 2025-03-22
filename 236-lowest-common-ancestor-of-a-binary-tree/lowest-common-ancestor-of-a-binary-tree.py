class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        
        if root == p or root == q:
            return root
        
        rleft=self.lowestCommonAncestor(root.left, p, q)
        rright=self.lowestCommonAncestor(root.right, p, q)

        if rleft is None:
            return rright
        
        if rright is None:
            return rleft

        return root