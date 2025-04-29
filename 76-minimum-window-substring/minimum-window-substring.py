class Solution:
    def minWindow(self, s: str, t: str) -> str:
        """
        Given two strings s and t, return the shortest substring of s such that every character in t,
        including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".

        You may assume that the correct output is always unique.
        """
        # get the length 
        sn=len(s)
        tn=len(t)
        # if the tn > sn return ""
        if tn > sn:
            # corner case, where the pattern is bigger in length than the original str s
            return ""
        # we need to find the smallest window from s where all characters from t is present
        # let's count the characters of string t
        tmap=Counter(t) # {x:1, y:2, z:1}
        # define an empty counter dict to count the frequency of characters in window
        smap=Counter()
        # default index and initializations
        start=0  # Changed from -1 to 0
        min_length=float('inf')  # Changed from sn to inf
        min_start=0  # Added to track start of minimum window
        # iterate on the characters of string s
        # we need to shrink the window whenever we found all characters in the map are present
        for end, c in enumerate(s):
            # put the character into the smap
            smap[c] = smap.get(c,0)+1
            # check if all the characters in tmap are present with required frequencies
            valid_window = all(smap[k] >= v for k,v in tmap.items())
            
            # if we have a valid window, try to minimize it
            while valid_window and start <= end:
                window_length = end - start + 1
                if window_length < min_length:
                    min_length = window_length
                    min_start = start
                
                # try to shrink window from start
                smap[s[start]] -= 1
                if s[start] in tmap and smap[s[start]] < tmap[s[start]]:
                    valid_window = False
                start += 1

        return s[min_start:min_start + min_length] if min_length != float('inf') else ""
