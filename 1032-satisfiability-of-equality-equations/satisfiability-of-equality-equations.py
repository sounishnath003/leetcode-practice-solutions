class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
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


        def satisfiability_eqs(equations):
            N = 256
            uf = UnionFind(N)
            for eq in equations:
                u = eq[0]
                v = eq[3]
                op = eq[1]
                if op == '=':
                    uf.union(ord(u), ord(v))

            for eq in equations:
                u = eq[0]
                v = eq[3]
                op = eq[1]
                if op == '!':
                    up = uf.find(ord(u))
                    vp = uf.find(ord(v))
                    if up == vp:
                        return False

            return True

        return satisfiability_eqs(equations)