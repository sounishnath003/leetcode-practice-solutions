class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1n=len(s1)
        s2n=len(s2)
        s1m=Counter(s1)
        s2m=defaultdict(int)
        for i in range(s2n):
            c1=s2[i]
            s2m[c1]+=1
            if s1m==s2m:
                return True
            if i-s1n+1 >= 0 and s2m[s2[i-s1n+1]]:
                s2m[s2[i-s1n+1]] -=1
                if s2m[s2[i-s1n+1]] == 0:
                    del s2m[s2[i-s1n+1]]

        return False
            
    def checkInclusion1(self, s1: str, s2: str) -> bool:
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
