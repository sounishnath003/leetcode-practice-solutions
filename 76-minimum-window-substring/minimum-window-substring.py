class Solution:
    def minWindow(self, s: str, c: str) -> str:
        # TCL O(N)
        def sol2():
            n = len(s)
            if len(c) > len(s): return ""
            cdict = Counter(c)
            start = 0
            smap = defaultdict(int)
            gmin = float("inf")
            starting_index = 0

            for end in range(n):
                char = s[end]
                smap[char] += 1
                # check if valid
                valid_window = all(smap.get(k, 0) >= cdict[k] for k in cdict)
                # as we need smaller substring contains all characters from cdict / c
                while valid_window and (start <= end):
                    window = (end - start) + 1
                    if window < gmin:
                        starting_index = start
                        gmin = window

                    smap[s[start]] -= 1
                    start += 1
                    valid_window = all(smap.get(k, 0) >= cdict[k] for k in cdict)

            if gmin != float("inf"):
                return s[starting_index : starting_index + gmin]
            else:
                return ""
        return sol2()