class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        def build_graph(prerequisites: List[List[int]]) -> Dict[int, List[int]]:
            graph: Dict[int, List[int]] = defaultdict(list)
            for u, v in prerequisites:
                graph[v].append(u)
            return graph

        graph = build_graph(prerequisites)
        
        visited: Dict[int, str] = {node: "NOT_VISITED" for node in range(numCourses)}
        
        def dfs(node:int):
            nonlocal visited, graph
            state = visited[node]
            if state == "VISITED": return True
            elif state == "VISITING": return False
            
            visited[node] = "VISITING"
            for nei in graph[node]:
                if not dfs(nei): return False

            visited[node] = "VISITED"
            return True

        for node in range(numCourses):
            if not dfs(node): return False

        return True