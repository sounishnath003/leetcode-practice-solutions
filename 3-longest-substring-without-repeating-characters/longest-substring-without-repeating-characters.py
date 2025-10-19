class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """returns the longest substring without repeating characters using hash map."""
        n = len(s)
        charmap = {}
        # max window length
        max_window = 0
        # define the start left most pointer
        start = 0
        # iterate over the string s
        for end, char in enumerate(s):
            if char in charmap and charmap[char] >= start:
                start = charmap[char] + 1
            charmap[char] = end
            window = (end - start +1)
            max_window = max(max_window, window)

        return max_window