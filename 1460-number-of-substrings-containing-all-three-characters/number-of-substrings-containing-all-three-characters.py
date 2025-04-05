# https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        # get the length
        n = len(s)
        # use a map to store the eleems
        mpp = {}
        # start point of sliding window
        start = 0
        # store the count of substring as result
        total_substring = 0
        # use the sliding window concept 
        # as we need to find the substrings
        for end in range(n):
            # get the character from the string
            ch = s[end]
            # add the letter into the mpp
            mpp[ch] = mpp.get(ch, 0) + 1
            
            # while we have all 3 chars, try to minimize window from start
            while len(mpp) == 3:
                total_substring += (n - end)
                # remove start char from window
                mpp[s[start]] -= 1
                if mpp[s[start]] == 0:
                    del mpp[s[start]]
                start += 1
                
        # return the result
        return total_substring


    def numberOfSubstringsNative(self, s: str) -> int:
        # get the length
        n = len(s)
        # results
        results = 0
        # iterate on the arr
        for i in range(n):
            # use dict instead of defaultdict
            mpp = {}
            for j in range(i, n):
                # add character to map
                mpp[s[j]] = mpp.get(s[j], 0) + 1
                
                # check if all 3 chars present
                if len(mpp) == 3:
                    # add remaining length since all substrings after this will contain abc
                    results += n - j
                    break

        return results