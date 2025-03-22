class Solution:
    def flatten(self, root):
        if not root:
            return None
        # inorder morris traversal
        curr=root
        while curr:
            # curr has left child
            if curr.left is not None:
                temp=curr.left
                # goto its right most children and do something
                while temp.right is not None:
                    temp=temp.right
                # connect the right most node to root's right
                temp.right=curr.right
                # change the curr left subtree to its right
                curr.right=curr.left
                # make the left children as None
                curr.left=None
                # move the curr to its next ndoe i.e right
                curr=curr.right
                
            else:
                curr=curr.right
                
        return root


    def flatten2(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        if not root:
            return

        # Flatten left and right subtrees
        self.flatten(root.left)
        self.flatten(root.right)

        # Store the right subtree
        right_subtree = root.right

        # Move the left subtree to the right
        root.right = root.left
        root.left = None

        # Find the tail of the new right subtree
        current = root
        while current.right:
            current = current.right

        # Attach the original right subtree
        current.right = right_subtree
        