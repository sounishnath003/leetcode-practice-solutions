class Solution:
    def reverseWords(self, s: str) -> str:
        s=s.strip()
        tokens=re.split("\\s+", s)
        return " ".join(tokens[::-1])