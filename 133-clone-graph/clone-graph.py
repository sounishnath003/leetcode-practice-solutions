# Definition for a Node.
class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

from typing import Optional

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None

        self.node_maps = {}  # Initialize node_maps within cloneGraph
        return self._clone(node)

    def _clone(self, node: Node) -> Optional['Node']:
        if node is None:
            return None

        if node in self.node_maps:  # Check if node is already cloned
            return self.node_maps[node]

        nnode = Node(node.val)
        self.node_maps[node] = nnode  # Store the cloned node immediately

        for nei in node.neighbors:
            neinode = self._clone(nei)
            nnode.neighbors.append(neinode)

        return nnode