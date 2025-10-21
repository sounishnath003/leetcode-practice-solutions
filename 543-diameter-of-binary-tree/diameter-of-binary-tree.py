class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        diameter = 0

        def calc_height(root):
            """simply find the height of the root"""
            # define it is a non local variable
            nonlocal diameter
            # if no root, nothing can be done.
            if not root:
                return 0
            # recursively calculate the left and right heights
            left_height = calc_height(root.left)
            right_height = calc_height(root.right)
            # calculate diameter
            diameter = max(diameter, left_height + right_height)

            # find the height pass by the root
            return 1 + max(left_height, right_height)

        calc_height(root)

        return diameter