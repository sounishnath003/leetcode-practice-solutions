class Solution:
    def minMaxWeight(self, n: int, edges: list[list[int]], threshold: int) -> int:
        # Get all unique weights to binary search over the sorted list of weights
        # This is more efficient than searching the range [min_w, max_w]
        weights = sorted(list(set(edge[2] for edge in edges)))
        
        # Build the reverse graph once
        adj = defaultdict(list)
        for u, v, w in edges:
            adj[v].append((u, w))
            
        def is_possible(max_w: int) -> bool:
            # Standard BFS from node 0 to see if all nodes are reachable
            # in the REVERSED graph.
            q = deque([0])
            visited = {0}
            count = 0
            
            while q:
                u = q.popleft()
                count += 1
                for v, w in adj[u]:
                    if v not in visited and w <= max_w:
                        visited.add(v)
                        q.append(v)
            
            return count == n

        low = 0
        high = len(weights) - 1
        ans = -1

        while low <= high:
            mid = (low + high) // 2
            if is_possible(weights[mid]):
                ans = weights[mid]
                high = mid - 1
            else:
                low = mid + 1
                
        return ans