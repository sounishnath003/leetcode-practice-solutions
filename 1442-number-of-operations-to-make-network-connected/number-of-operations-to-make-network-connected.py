class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        class UnionFind:
            def __init__(self, N:int):
                self.parents = list(range(N))
                self.rank = [1] * N

            def union(self, u: int, v: int) -> bool:
                up = self.find(u)
                vp = self.find(v)

                if up == vp:
                    return False

                if self.rank[up] > self.rank[vp]:
                    self.parents[vp] = up
                elif self.rank[up] < self.rank[vp]:
                    self.parents[up] = vp
                else:
                    self.parents[vp] = up
                    self.rank[up] += 1

                return True

            def find(self, u:int) -> int:
                if u == self.parents[u]:
                    return u
                self.parents[u] = self.find(self.parents[u])
                return self.parents[u]

        # base:
        # you need 2 edges to connect 3 vertex/components
        if len(connections) < n-1:
            return -1
        uf = UnionFind(n)
        components = n
        for conn in connections:
            u, v = conn[0], conn[1]
            if uf.union(u,v):
                components -= 1

        return components - 1