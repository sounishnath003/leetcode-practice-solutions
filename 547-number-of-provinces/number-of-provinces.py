# https://leetcode.com/problems/number-of-provinces/

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        visited = set()
        provinces = 0

        def dfs(node):
            visited.add(node)
            # Check all possible neighbors
            for neighbor in range(n):
                # If connected AND not visited yet
                if isConnected[node][neighbor] == 1 and neighbor not in visited:
                    dfs(neighbor)

        for i in range(n):
            if i not in visited:
                # We found a new "island", start a DFS to mark the whole island
                dfs(i)
                # Increment the count once per island found
                provinces += 1
                
        return provinces


class Solution2:
    def findCircleNum(self, isConnected: list[list[int]]) -> int:
        n = len(isConnected)
        parent = list(range(n))
        # Start with n provinces, we will subtract as we merge
        self.provinces = n 
        
        def find(i):
            if parent[i] == i:
                return i
            # Path Compression: makes future finds O(1)
            parent[i] = find(parent[i]) 
            return parent[i]
            
        def union(i, j):
            root_i = find(i)
            root_j = find(j)
            if root_i != root_j:
                parent[root_i] = root_j
                # Two separate groups just became one
                self.provinces -= 1
        
        # Check every pair of cities
        for i in range(n):
            for j in range(i + 1, n):
                if isConnected[i][j] == 1:
                    union(i, j)
                    
        return self.provinces