class Solution:
    def isPalindrome(self, s: str) -> bool:
        punc = '''!()-[]{};`:'"\, <>./?@#$%^&*_~'''
        s = s.lower()
        s.replace(" ", '')
        for x in s:
            if x in punc:
                s = s.replace(x, "")
        return s[::-1] == s
