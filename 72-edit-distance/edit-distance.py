class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # return self.func(word1, word2, sn-1, tn-1, dp)
        sn=len(word1)
        tn=len(word2)

        dp = [[0 for _ in range(tn+1)] for _ in range(sn+1)]

        for i in range(sn+1):
            dp[i][0]=i
        
        for j in range(tn+1):
            dp[0][j]=j

        for i in range(1, sn+1):
            for j in range(1, tn+1):
                # if same
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    op_add = dp[i-1][j]
                    op_del = dp[i][j-1]
                    op_repl = dp[i-1][j-1]

                    dp[i][j] = 1 + min([op_add, op_del, op_repl])

        return dp[sn][tn]
    
    def func(self, s, t, i, j, dp):
        if i < 0:
            return j+1
        if j < 0:
            return i+1
        
        if dp[i][j] != -1:
            return dp[i][j]
        
        # if 2 characters are same
        if s[i] == t[j]:
            return self.func(s,t,i-1,j-1, dp)
        
        # if they are different
        # we need to perform either of ADD, DELETE, REPLACE operations
        op_add = self.func(s,t,i-1,j, dp)
        op_del = self.func(s,t,i,j-1, dp)
        op_repl = self.func(s,t,i-1,j-1, dp)

        # pick minimum of these
        dp[i][j] = 1 + min([op_add, op_del, op_repl])

        return dp[i][j]