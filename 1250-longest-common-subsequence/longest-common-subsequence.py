
def lcs(s, t, si, ti, memo=None):
    if memo is None:
        memo = {}
    
    # Base cases
    if si < 0 or ti < 0:
        return 0
    
    # Check memo
    if (si, ti) in memo:
        return memo[(si, ti)]
    
    # If characters match
    if s[si] == t[ti]:
        memo[(si, ti)] = 1 + lcs(s, t, si-1, ti-1, memo)
        return memo[(si, ti)]
    
    # If characters don't match, take maximum of both possibilities
    memo[(si, ti)] = max(
        lcs(s, t, si-1, ti, memo),
        lcs(s, t, si, ti-1, memo)
    )
    return memo[(si, ti)]

class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        return  lcs(text1,text2, len(text1)-1, len(text2)-1)