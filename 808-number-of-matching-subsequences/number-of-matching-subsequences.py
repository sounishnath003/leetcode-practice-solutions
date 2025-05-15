
class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        # bruteforce soln:
            # 1. generate all subsequence of a string and count++
        # optimzied:
            # 1. implement the trie of the words provided
            # 2. search the indexes everytime in the trie
        
        root = {}

        def insert(word: str) -> None:
            node=root
            for char in word:
                if char not in node:
                    node[char] = {"count":  0}
                node=node[char]
            
            node["count"] +=1

        # for all word in words store into the trie
        for word in words:
            insert(word)

        def find_matching(s: str, i: int, node: dict) -> int:
            ans  = node["count"] if "count" in node else 0

            if i >= len(s):
                return ans
            
            for c in string.ascii_lowercase:
                if c in node:
                    try:
                        index = s.index(c, i)
                        ans += find_matching(s, i+1, node[c])
                    except Exception:
                        continue
            
            return ans
        

        return find_matching(s,0,root)

class Solution:
  def numMatchingSubseq(self, s: str, words: list[str]) -> int:
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

    def dfs(s: str, i: int, node: dict) -> int:
      ans = node['count'] if 'count' in node else 0

      if i >= len(s):
        return ans

      for c in string.ascii_lowercase:
        if c in node:
          try:
            index = s.index(c, i)
            ans += dfs(s, index + 1, node[c])
          except ValueError:
            continue

      return ans

    return dfs(s, 0, root)