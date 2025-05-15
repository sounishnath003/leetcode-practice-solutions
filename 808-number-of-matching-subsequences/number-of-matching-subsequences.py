class Solution:
  def numMatchingSubseq(self, s: str, words: list[str]) -> int:
    # using the simple subsequence check
    # here u don't have to generate any subsequence, rather just confirm on the existence 
    # of the character in the main string

    def is_matched(s: str, word: str):
      last_index=0

      for c in word:
        last_index=s.find(c, last_index)
        if last_index == -1:
          return False
        last_index+=1
        
      return True

    matched=0
    for word in words:
      if is_matched(s, word):
        matched+=1

    return matched

  def numMatchingSubseq2(self, s: str, words: list[str]) -> int:
    # bruteforce soln:
        # 1. generate all subsequence of a string and count++
    # optimzied:
        # 1. implement the trie of the words provided
        # 2. search the indexes everytime in the trie
    
    root = {}

    def insert(word: str) -> None:
      node = root
      for c in word:
        if c not in node:
          node[c] = {'count': 0}
        node = node[c]
      node['count'] += 1

    for word in words:
      insert(word)

    print("trie:", root)

    def dfs(s: str, i: int, node: dict) -> int:
      ans = node['count'] if 'count' in node else 0

      if i >= len(s):
        return ans

      for c in s[i:]:
        if c in node:
          try:
            index = s.index(c, i)
            ans += dfs(s, index + 1, node[c])
          except ValueError:
            continue

      return ans

    return dfs(s, 0, root)
  
