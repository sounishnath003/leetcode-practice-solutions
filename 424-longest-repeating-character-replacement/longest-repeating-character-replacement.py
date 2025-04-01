class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freqmap = {}
        start = 0
        res = 0
        for end in range(len(s)):
            freqmap[s[end]] = 1 + freqmap.get(s[end], 0)
            window_length = end - start + 1
            while window_length - max(freqmap.values()) > k:
                freqmap[s[start]] -= 1
                if freqmap[s[start]] == 0:
                    del freqmap[s[start]]  # Remove key when count is zero
                start += 1
                window_length = end - start + 1  # Update window length
            res = max(res, window_length)

        return res