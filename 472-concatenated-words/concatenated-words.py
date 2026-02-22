class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        wordset = set(words)
        
        @lru_cache
        def is_concatinated(word):
            n = len(word)
            for i in range(1,n):
                prefix, suffix = word[:i], word[i:]
                if prefix in wordset and (suffix in wordset or is_concatinated(suffix)):
                    return True
            return False
        
        results = [ word for word in words if is_concatinated(word) ]
        return results