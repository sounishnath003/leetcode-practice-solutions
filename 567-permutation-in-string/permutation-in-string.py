class Solution:
    def checkInclusion(self, s: str, t: str) -> bool:
        sn = len(s)
        tn = len(t)
        # check if the sn is bigger than the tn
        if tn < sn:
            # it is not possible that the possible match is longer 
            # than the string i will be looking at; hence return False
            return False

        # declare two pointers
        start = 0
        # declare some mapps of characters to store
        smap = Counter(s)
        tmap = defaultdict(int) # default dict: char -> frequency.int
        # iterate over the t string and check for the window of sn length
        for end in range(tn):
            tchar = t[end]
            # put it in tmap
            tmap[tchar] += 1
            # check the window length
            window = (end - start + 1)
            # if you have hit the same sn length window now check followings
            if window == sn:
                # if both map has equal number of characters stored
                if tmap == smap:
                    return True
                # also remove the t[start] count from the tmap
                tmap[t[start]] -=1
                # if the count is 0 then remove the key from the tmap
                if tmap[t[start]] == 0:
                    del tmap[t[start]]
                # increment the start pointer
                start += 1

        # no observation of having the permutation present in the tn
        return False