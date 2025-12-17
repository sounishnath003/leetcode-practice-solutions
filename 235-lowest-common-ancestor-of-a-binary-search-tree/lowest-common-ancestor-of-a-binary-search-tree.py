
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
       if not root: return root
       if root.val < p.val and root.val < q.val: return self.lowestCommonAncestor(root.right,p,q)
       if root.val > p.val and root.val > q.val: return self.lowestCommonAncestor(root.left,p,q)
       return root