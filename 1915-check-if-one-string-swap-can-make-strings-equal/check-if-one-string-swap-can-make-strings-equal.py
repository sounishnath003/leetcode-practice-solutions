class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        # Find the indices where s1 and s2 differ
        diff = []
        
        for i in range(len(s1)):
            if s1[i] != s2[i]:
                diff.append(i)
        
        # Case 1: strings already equal
        if len(diff) == 0:
            return True
        
        # Case 2: exactly two characters differ
        if len(diff) == 2:
            i, j = diff
            return s1[i] == s2[j] and s1[j] == s2[i]
        
        # Any other number of mismatches — not possible
        return False
