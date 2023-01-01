class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        str = str.split(' ')
        if  not len(str) == len(pattern):
                return False
        return len(set(zip(pattern, str))) == len(set(str)) == len(set(pattern))
