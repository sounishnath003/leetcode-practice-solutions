class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        def build_graph(prerequisites: List[List[int]]) -> Dict[int, List[int]]:
            graph: Dict[int, List[int]] = defaultdict(list)
            for u, v in prerequisites:
                graph[v].append(u)
            return graph

        graph = build_graph(prerequisites)

        # Using Kahns algorithm - BFS
        def kahns(graph):
            indegrees = [0] * numCourses
            for u in graph:
                for v in graph[u]:
                    indegrees[v] += 1
            
            count = 0
            q = deque()
            for u in range(numCourses):
                if indegrees[u]==0:
                    q.append(u)
                    count += 1

            while q:
                node = q.popleft()
                for nei in graph[node]:
                    indegrees[nei] -= 1
                    if indegrees[nei] == 0:
                        q.append(nei)
                        count += 1
            
            return count == numCourses
        
        return kahns(graph)
        
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