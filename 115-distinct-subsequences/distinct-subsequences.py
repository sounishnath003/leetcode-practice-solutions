# https://leetcode.com/problems/distinct-subsequences/

class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        n=len(s)
        m=len(t)

        dp=[[0 for _ in range(m+1)] for _ in range(n+1)]
        prev=[0 for _ in range(m+1)]
        prev[0]=1

        # base condn: if j == 0 all are 1s
        for i in range(n):
            dp[i][0] = 1

        # iterate over and build
        for i in range(1,n+1):
            current=[0 for _ in range(m+1)]
            current[0]=1
            for j in range(1,m+1):
                # check if characters are same?
                if s[i-1] == t[j-1]:
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
                    current[j] = prev[j] + prev[j-1]
                else:
                    dp[i][j] = dp[i-1][j]
                    current[j]=prev[j]

            prev=current.copy()

        return prev[m]


    def numDistinct2(self, s: str, t: str) -> int:
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