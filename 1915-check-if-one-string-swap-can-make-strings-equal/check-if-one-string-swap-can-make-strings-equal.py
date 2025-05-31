class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        if s1 == s2:
            return True
        
        # store the indexes where the mismatching has happened
        diff=list()
        # iterate and store all the results (differences)
        for i, c in enumerate(s1):
            # so characters are different
            if s1[i] != s2[i]:
                diff.append(i)
        
        # so extactly there has to the 2 values right?
        if len(diff) == 1 or len(diff) > 2:
            return False
        
        # pull out the indexes
        i, j = diff
        # just simply return
        return s1[i] == s2[j] and s2[i] == s1[j]