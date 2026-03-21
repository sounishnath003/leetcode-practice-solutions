class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        # hd -> list of (row, val)
        node_map = defaultdict(list)
        q = deque([(root, 0, 0)])  # node, hd, level

        while q:
            node, hd, level = q.popleft()
            node_map[hd].append((level, node.val))

            if node.left:
                q.append((node.left, hd-1, level+1))
            if node.right:
                q.append((node.right, hd+1, level+1))

        # Build the final result
        result = []
        for hd in sorted(node_map):  # iterate columns in sorted order
            col_nodes = sorted(node_map[hd], key=lambda x: (x[0], x[1]))  # sort by row, then value
            result.append([val for row, val in col_nodes])  # extract values only

        return result