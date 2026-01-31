class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        tokens = s.split()
        if len(pattern) != len(tokens):
            return False

        pmap = {}
        smap = {}

        for i in range(len(pattern)):
            char = pattern[i]
            word = tokens[i]

            if char in pmap:
                if pmap[char] != word:
                    return False
            else:
                if word in smap:
                    return False
                pmap[char] = word
                smap[word] = char

        return True
