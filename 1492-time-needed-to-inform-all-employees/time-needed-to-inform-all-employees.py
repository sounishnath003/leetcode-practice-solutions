class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        # Create an adjacency list to represent the hierarchy
        hierarchy = {i: [] for i in range(n)}
        for emp, mgr in enumerate(manager):
            if mgr != -1:
                hierarchy[mgr].append(emp)

        # Perform DFS to calculate the total time
        return self.dfs(headID, hierarchy, informTime)

    def dfs(self, mgr, hierarchy, informTime):
        # Base case: if the manager has no subordinates
        if not hierarchy[mgr]:
            return 0

        max_time = 0
        for emp in hierarchy[mgr]:
            max_time = max(max_time, self.dfs(emp, hierarchy, informTime))

        # Add the current manager's inform time
        return max_time + informTime[mgr]