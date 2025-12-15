# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        max_width = 0
        first_seen_index_at_level = defaultdict(int)

        def dfs(root, level:int, index:int):
            nonlocal max_width, first_seen_index_at_level
            if not root: return 
            # i will keep the index at the level if 1stly found
            if level not in first_seen_index_at_level: first_seen_index_at_level[level] = index
            # faith
            dfs(root.left, level+1, 2*index)
            dfs(root.right, level+1, 2*index+1)

            # my width
            width = index - first_seen_index_at_level[level] + 1
            max_width = max(width, max_width)

        # dfs(root,0,1)
        # return max_width

        q = deque([(root, 0, 1)])
        while q:
            qs = len(q)
            _, level, first_index = q[0]
            _, level, last_index = q[-1]
            width = last_index - first_index + 1
            max_width = max(max_width, width)
            # traverse on the q level
            for _ in range(qs):
                node, level, index = q.popleft()
                # index = index - first_index : skipping overflow issue
                if node.left:
                    q.append((node.left, level+1, 2*index))
                if node.right:
                    q.append((node.right, level+1, 2*index+1))


        return max_width