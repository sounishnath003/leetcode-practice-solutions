class Solution:
    def maxNumOfSubstrings(self, s:str) -> list[str]:
        first=dict()
        last=dict()

        for i, c in enumerate(s):
            if c not in first:
                first[c] = i
            last[c] = i

        intervals =[]
        for c in first:
            l, r = first[c], last[c]
            i = l
            while i <= r:
                if first[s[i]] < l:
                    l = first[s[i]]
                    i = l
                    continue
                elif last[s[i]] > r:
                    r = last[s[i]]
                    i = l
                    continue
                
                i += 1
            intervals.append((l,r))

        intervals.sort(key=lambda x: x[1])

        result =[]
        end = -1
        for l, r in intervals:
            if l > end:
                result.append(s[l:r+1])
                end = r

        return result