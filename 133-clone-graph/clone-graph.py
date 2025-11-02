class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        node_map = defaultdict(Node)

        def clone(node: "Node"):
            nonlocal node_map
            if not node: return None

            if node in node_map: return node_map[node]
            
            node_map[node] = Node(node.val)
            for neigh in node.neighbors:
                cloned_neigh = clone(neigh)
                node_map[node].neighbors.append(cloned_neigh)

            return node_map[node]

        return clone(node)