from collections import deque, defaultdict
from typing import List, Optional

class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        # Dictionary to store the nodes at each horizontal distance
        column_table = defaultdict(list)
        # Queue to perform BFS
        queue = deque([(root, 0, 0)])  # (node, column, row)

        while queue:
            node, column, row = queue.popleft()
            if node is not None:
                column_table[column].append((row, node.val))
                queue.append((node.left, column - 1, row + 1))
                queue.append((node.right, column + 1, row + 1))

        # Sort the dictionary by column
        sorted_columns = sorted(column_table.items())
        result = []
        for column, value in sorted_columns:
            # Sort by row and value
            value.sort(key=lambda x: (x[0], x[1]))
            column_values = [val for row, val in value]
            result.append(column_values)

        return result
