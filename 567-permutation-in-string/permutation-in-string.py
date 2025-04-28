class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1n=len(s1)
        s2n=len(s2)
        s1m=[0] * 26
        for i, c in enumerate(s1):
            s1m[ord(c) - ord('a')] += 1

        for i in range(s2n-s1n+1):
            t=s2[i:i+s1n]
            tm = [0] * 26
            for i, c in enumerate(t):
                tm[ord(c)-ord('a')] +=1

            if tm==s1m:
                return True

        return False
