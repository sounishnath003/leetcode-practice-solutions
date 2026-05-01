
# using the rabin krap -> hashing technique
# TC: O(N) ; SC: O(1)
class Solution:
    def longestPrefix(self, s: str) -> str:
        n = len(s)

        mod = 10**9 + 7
        base = 31

        prefix_hash = 0
        suffix_hash = 0
        power = 1

        res_len = 0

        for i in range(n - 1):  # exclude full string
            # build prefix hash
            prefix_hash = (prefix_hash * base + ord(s[i])) % mod

            # build suffix hash
            suffix_hash = (suffix_hash + ord(s[n - 1 - i]) * power) % mod

            power = (power * base) % mod

            if prefix_hash == suffix_hash:
                res_len = i + 1

        return s[:res_len]

# using the KMP -> LPS array technique: 
# TC: O(N) ; SC: O(N)
class Solution2:
    def longestPrefix(self, s: str) -> str:
        n = len(s)
        lps = [0] * n

        j = 0  # length of previous longest prefix-suffix

        for i in range(1, n):
            while j > 0 and s[i] != s[j]:
                j = lps[j - 1]

            if s[i] == s[j]:
                j += 1

            lps[i] = j

        return s[:lps[-1]]