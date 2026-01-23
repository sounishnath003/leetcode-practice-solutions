class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        class UnionFind:
            def __init__(self, n:int):
                self.parents=list(range(n))
                self.rank = [1] * n

            def union(self, u:int, v:int):
                up=self.find(u)
                vp=self.find(v)

                if up==vp:
                    return False

                if self.rank[up] > self.rank[vp]:
                    self.parents[vp] = up
                elif self.rank[up] < self.rank[vp]:
                    self.parents[up] = vp
                else:
                    self.parents[vp] = up
                    self.rank[up] += 1

            def find(self, u:int) -> int:
                if u == self.parents[u]: return u
                self.parents[u] = self.find(self.parents[u])
                return self.parents[u]

        def count_unreachable_pairs(n, edges):
            uf = UnionFind(n)
            for u,v in edges:
                uf.union(u,v)

            component_size_map = Counter([uf.find(u) for u in range(n)])
            # formula is: size x (remaning - size)
            remaining = n
            pairs = 0

            for size in component_size_map.values():
                pairs += (size * (remaining - size))
                remaining -= size

            return pairs

        return count_unreachable_pairs(n,edges)
 