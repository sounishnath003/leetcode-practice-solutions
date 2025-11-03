class Solution:
    def cloneGraph(self, node: Optional['Node'], use_iterative: bool = True) -> Optional['Node']:
        """
        Clone an undirected graph.
        Set `use_iterative=True` to use iterative DFS (stack-based).
        Set `use_iterative=False` to use recursive DFS.
        """
        if not node:
            return None

        # Shared mapping: original -> clone
        node_map = {}

        # --- Recursive DFS ---
        def clone_recursive(curr: 'Node') -> 'Node':
            if curr in node_map:
                return node_map[curr]

            copy = Node(curr.val)
            node_map[curr] = copy
            for neighbor in curr.neighbors:
                copy.neighbors.append(clone_recursive(neighbor))
            return copy

        # --- Iterative DFS ---
        def clone_iterative(start: 'Node') -> 'Node':
            node_map[start] = Node(start.val)
            stack = [start]

            while stack:
                curr = stack.pop()
                for neighbor in curr.neighbors:
                    if neighbor not in node_map:
                        node_map[neighbor] = Node(neighbor.val)
                        stack.append(neighbor)
                    node_map[curr].neighbors.append(node_map[neighbor])

            return node_map[start]

        # Choose strategy
        if use_iterative:
            return clone_iterative(node)
        else:
            return clone_recursive(node)
