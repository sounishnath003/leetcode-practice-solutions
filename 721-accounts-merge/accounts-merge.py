
# LC: 721
# https://leetcode.com/problems/accounts-merge/

from collections import defaultdict

class UnionFind:
    def __init__(self, N:int) -> None:
        self.parents = list(range(N))
        self.components = N
        self.rank = [1] * N

    def find(self, u:int) -> int:
        if self.parents[u] == u:
            return u
        self.parents[u] = self.find(self.parents[u])
        return self.parents[u]

    def union(self, u:int, v:int) -> bool:
        pu, pv = self.find(u), self.find(v)
        if pu == pv:
            return False

        if self.rank[pu] > self.rank[pv]:
            self.parents[pv] = pu
        elif self.rank[pu] < self.rank[pv]:
            self.parents[pu] = pv
        else:
            self.parents[pv] = pu
            self.rank[pu] += 1
        
        self.components -= 1
        return True
    

class Solution:
    def accountsMerge(self, accounts: list[list[str]]) -> list[list[str]]:
        emails_map = {} # email -> index
        n = len(accounts)
        uf = UnionFind(n)

        for userid in range(n):
            emails = accounts[userid][1:]
            for email in emails:
                if email not in emails_map:
                    emails_map[email] = userid
                else:
                    uf.union(userid, emails_map[email])

        merged_emails = defaultdict(list)
        for email, userid in emails_map.items():
            parent = uf.find(userid)
            merged_emails[parent].append(email)

        return [[accounts[i][0]] + sorted(emails) for i, emails in merged_emails.items()]