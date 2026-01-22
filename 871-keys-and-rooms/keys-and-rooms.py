class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = set()
        def dfs_fn(node):
            visited.add(node)
            for nei in rooms[node]:
                if nei not in visited:
                    dfs_fn(nei)
        
        dfs_fn(0)
        return len(visited) == len(rooms)