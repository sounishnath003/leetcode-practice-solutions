class Solution:
    def beautySum(self, s: str) -> int:
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
