class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        def f(s, wordset, cur, dp):
            if len(s) == 0 or s in wordset: return True
            if s in dp: return dp[s]
            # generate all possible substring starting from 0..i
            for i in range(1, len(s)):
                prefix = s[:i]
                ros = s[i:]
                if prefix not in wordset: continue
                cur.append(prefix)
                res =  f(ros, wordset, cur, dp)
                if res:
                    # store the breaks into dp
                    dp[prefix] = True
                    dp[ros] = True
                    return True
                cur.pop()

            dp[s] = False
            return False

        wordset = set(wordDict)
        return f(s, wordset, [], {})