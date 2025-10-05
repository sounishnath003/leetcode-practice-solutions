class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        count = 0
        # 1. count of the number of characters
        count_freq = defaultdict(int)
        balloon = 'balloon'
        # 2. iterate over words and increase the freq
        for char in text:
            if char in balloon:
                count_freq[char] += 1
        # 3. if any character is unseen return 0
        if any(c not in count_freq for c in balloon):
            return 0
        # 3. check the minimum
        return min(
            count_freq['b'],
            count_freq['a'],
            count_freq['l']//2,
            count_freq['o']//2,
            count_freq['n']
        )
