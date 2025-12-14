class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        def f(s, wordset, map):
            if not s: return [""]
            if s in map: return map[s]

            res = []
            if s in wordset:
                res.append(s)

            for i in range(1, len(s)):
                prefix = s[:i]
                ros = s[i:]
                if prefix not in wordset: continue

                # faith
                suffix_words = f(ros, wordset, map)
                res.extend([prefix + " " + sw for sw in suffix_words])

            map[s] = res[:]

            return res

        return f(s, set(wordDict), {})