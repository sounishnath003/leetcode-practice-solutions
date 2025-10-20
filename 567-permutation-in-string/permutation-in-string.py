class Solution:
    def checkInclusion(self, s: str, t: str) -> bool:
        sn = len(s)
        tn = len(t)
        # t is the string i will be iterate on
        if sn > tn:
            return False

        start = 0
        smap = Counter(s)
        tmap = defaultdict(int)

        for end in range(tn):
            tmap[t[end]] += 1
            window = (end - start + 1)
            if window == sn:
                # if all([True if tmap[k] == smap[k] else False for k in smap.keys()]):
                if tmap == smap:
                    return True
                tmap[t[start]] -= 1
                if tmap[t[start]] == 0:
                    del tmap[t[start]]
                start += 1
        return False