class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        if not root: return [0]
        # we have use BFS traversal
        q = deque((root, ))
        results = []
        while q:
            total = 0
            qn = len(q)
            for _ in range(qn): 
                node = q.popleft()
                total += node.val
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            avg = total/qn
            results.append(avg)

        return results

