class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        def build_graph(prerequisites: List[List[int]]) -> Dict[int, List[int]]:
            graph: Dict[int, List[int]] = defaultdict(list)
            for u, v in prerequisites:
                graph[v].append(u)
            return graph

        graph = build_graph(prerequisites)
        
        visited: Dict[int, str] = {node: "NOT_VISITED" for node in range(numCourses)}
        path = []
        
        def dfs(node:int):
            nonlocal visited, graph, path
            state = visited[node]
            if state == "VISITED": return True
            elif state == "VISITING": return False
            
            visited[node] = "VISITING"
            for nei in graph[node]:
                if not dfs(nei): return False

            visited[node] = "VISITED"
            path.append(node)
            return True

        for node in range(numCourses):
            if not dfs(node): return []

        return path[::-1]