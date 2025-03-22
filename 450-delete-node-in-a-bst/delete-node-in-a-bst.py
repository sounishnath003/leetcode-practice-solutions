class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        def max(root):
            while root.right is not None:
                root=root.right
            return root.val
        
        # if no root
        if root is None:
            return None
        
        # traverse like BST only
        if root.val > key:
            root.left=self.deleteNode(root.left, key)
        elif root.val < key:
            root.right=self.deleteNode(root.right, key)
        else:
            if root.left is not None and root.right is not None:
                # left child max
                lmax=max(root.left)
                # replace the value of its
                root.val=lmax
                # max delete kardo
                root.left=self.deleteNode(root.left, lmax)
                return root
            elif root.left is not None:
                return root.left
            elif root.right is not None:
                return root.right
            else:
                return None
            
        return root