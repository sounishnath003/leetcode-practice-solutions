class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        sn, tn = len(s), len(t)
        if sn != tn: return False

        charmap = {}
        charmap2 = {}
        # iterate over the s and add the {s[i] -> t[i]}
        for i, char in enumerate(s):
            tchar = t[i]

            # check the mapping
            op1 = char in charmap and charmap[char] != tchar
            op2 = tchar in charmap2 and charmap2[tchar] != char
            if op1 or op2: return False
            
            charmap[char] = tchar
            charmap2[tchar] = char

        return all(charmap[char] == t[i] for i, char in enumerate(s))