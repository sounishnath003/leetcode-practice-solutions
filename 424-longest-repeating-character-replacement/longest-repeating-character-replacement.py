class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        """return the longest window of characters you can 
        get after performing the operations at most K times"""
        start = 0
        charmap = defaultdict(int)
        mwindow = 0

        # iterate over the string
        for end, char in enumerate(s):
            charmap[char] += 1
            # while
            while (end - start + 1) - int(max(charmap.values())) > k:
                charmap[s[start]] -= 1
                start += 1
            mwindow = max(mwindow, (end - start + 1))

        return mwindow
