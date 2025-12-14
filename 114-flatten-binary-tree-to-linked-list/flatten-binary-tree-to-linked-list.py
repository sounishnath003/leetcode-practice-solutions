class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root: return None
        while root:
            if root.left:
                oleft = root.left
                curr = root.left
                while curr.right: curr = curr.right
                curr.right = root.right # morris traversal main logic
                root.right = oleft
                root.left = None

            root = root.right

    def flatten2(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        prev = None
        def dfs(root):
            nonlocal prev
            if not root: return
            # faith
            dfs(root.right)
            dfs(root.left)

            # my work
            root.right = prev
            root.left = None
            prev = root

        dfs(root)

        