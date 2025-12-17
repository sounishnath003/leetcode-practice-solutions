class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordset = set(wordList)
        if endWord not in wordset: return 0

        q=deque([(beginWord, 1)])
        while q:
            word, pathlen = q.popleft()
            if word == endWord: return pathlen

            for i in range(len(word)):
                for c in range(26):
                    new_char=chr(ord('a')+c)
                    if new_char==word[i]: continue
                    new_word = word[:i] + new_char + word[i+1:]
                    if new_word not in wordset: continue
                    q.append((new_word, pathlen +1))
                    wordset.remove(new_word)

        return 0