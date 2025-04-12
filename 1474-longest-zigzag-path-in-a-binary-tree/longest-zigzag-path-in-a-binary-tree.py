class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        self.max_len = 0

        def dfs(node):
            if not node:
                return (-1, -1)  # base: no path

            left = dfs(node.left)
            right = dfs(node.right)

            # Update global max_len using paths starting from current node
            self.max_len = max(self.max_len, left[1] + 1, right[0] + 1)

            return (left[1] + 1, right[0] + 1)  # (go_left, go_right)

        dfs(root)
        return self.max_len

    def longestZigZag2(self, root: Optional[TreeNode]) -> int:
        def bfs(start_node, going_left):
            queue = deque([(start_node, going_left, 0)])  # (node, direction, path_length)
            max_len = 0

            while queue:
                node, direction, path_length = queue.popleft()
                max_len = max(max_len, path_length)

                if direction:  # Last move was to the left, so go right next
                    if node.right:
                        queue.append((node.right, False, path_length + 1))
                else:  # Last move was to the right, so go left next
                    if node.left:
                        queue.append((node.left, True, path_length + 1))
            return max_len

        def traverse(node):
            if not node:
                return 0
            return max(
                bfs(node, True),
                bfs(node, False),
                traverse(node.left),
                traverse(node.right)
            )

        return traverse(root)
