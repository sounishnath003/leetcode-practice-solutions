class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        if 0 == n: return 0
        if s[0] == '0': return 0

        @lru_cache
        def fn(i:int) -> int:
            if i == n: return 1
            if s[i] == '0': return 0
            
            # choices: one_digit + two_digit
            opts = fn(i+1)
            if (i+1 < n and ((s[i] == '1') or (s[i] == '2' and s[i+1] <= '6'))):
                opts += fn(i+2)

            return opts

        return fn(0)