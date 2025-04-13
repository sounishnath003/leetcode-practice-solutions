class Solution:
    def frequencySort(self, s: str) -> str:
        freq = Counter(s)
        sorted_chars = sorted(freq.items(), key=lambda kv: kv[1], reverse=True)
        return ''.join([char * count for char, count in sorted_chars])
