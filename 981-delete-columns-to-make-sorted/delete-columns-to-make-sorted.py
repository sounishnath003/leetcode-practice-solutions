class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        def is_sorted(l):
            return all(a <= b for a, b in zip(l, l[1:]))

        n = len(strs) # given words # rows
        m = len(strs[0]) # length of word # columns

        delete=0
        seen={}
        for c in range(m):
            l=[ strs[r][c] for r in range(n) ]
            if tuple(sorted(l)) in seen:
                if seen[sorted(l)]:
                    delete +=1
            else:
                if not is_sorted(l):
                    delete+=1
                    seen[tuple(sorted(l))]=True
        return delete