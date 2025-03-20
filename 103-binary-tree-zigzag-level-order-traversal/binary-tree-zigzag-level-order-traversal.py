# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result=[]

        if not root:
            return result

        is_ltr=True
        queue = deque([root])

        while queue:
            qsize=len(queue)
            nodelist=[]
            for i in range(qsize):
                node=queue.popleft()

                if is_ltr:
                    nodelist.append(node.val)
                else:
                    nodelist.insert(0, node.val)

                if node.left:
                    queue.append(node.left)
                
                if node.right:
                    queue.append(node.right)

            result.append(nodelist)
            is_ltr = not is_ltr

        return result