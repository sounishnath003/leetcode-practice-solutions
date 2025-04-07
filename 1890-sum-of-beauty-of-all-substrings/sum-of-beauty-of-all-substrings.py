class Solution:
    def beautySum(self, s: str) -> int:
        n = len(s)
        total_beauty_sum = 0

        for start in range(n):
            char_freq = {}  # Frequency of characters in the current substring

            for end in range(start, n):
                char = s[end]
                char_freq[char] = char_freq.get(char, 0) + 1

                min_freq=min(char_freq.values())
                max_freq=max(char_freq.values())
                total_beauty_sum += (max_freq - min_freq)

        return total_beauty_sum

    def beautySumSlow(self, s: str) -> int:
        maxf=-float("inf")
        minf=float("inf")
        charfreq={}

        result=0

        for start in range(len(s)):
            for end in range(start,len(s)):
                word=s[start:end+1]
                charfreq={i:word.count(i) for i in set(word)}
                maxf=max(charfreq.values())
                minf=min(charfreq.values())
                result +=(maxf-minf)

        return result
