class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = set('aeiou')
        count = 0
        max_count = 0
        
        # Initial window of size k
        for i in range(k):
            count += 1 if s[i] in vowels else 0
        max_count = count
        
        # Slide the window
        for i in range(k, len(s)):
            if s[i] in vowels:
                count += 1
            if s[i - k] in vowels:
                count -= 1
            max_count = max(max_count, count)
        
        return max_count
