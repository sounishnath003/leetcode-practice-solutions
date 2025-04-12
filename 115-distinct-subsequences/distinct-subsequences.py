# https://leetcode.com/problems/distinct-subsequences/

class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        """
        find the unique ways to generate the target (t) from the string (s)
        subsequence: pick or not pick
        """

        dp={}
        def f(s,t,si,ti,dp):
            if ti < 0:
                return 1
            
            if si < 0:
                return 0
            
            if (si,ti) in dp:
                return dp[(si,ti)]
            
            if s[si] == t[ti]:
                dp[(si,ti)] =  f(s,t,si-1,ti,dp) + f(s,t,si-1,ti-1,dp)
                return dp[(si,ti)]
            
            dp[(si,ti)] = f(s,t,si-1,ti,dp)
            return dp[(si,ti)]

        si=len(s)
        ti=len(t)
        f(s,t,si-1,ti-1,dp)

        return dp[(si-1,ti-1)]