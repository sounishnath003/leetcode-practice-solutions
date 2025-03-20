# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        results=[]
        def func(root, height, results):
            if not root:
                return None
            if height == len(results):
                results.append(root.val)
            
            func(root.right, height+1, results)
            func(root.left, height+1, results)

        func(root, 0, results)
        return results
            
        