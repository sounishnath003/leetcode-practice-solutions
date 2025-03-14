class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        sn=len(word1)
        tn=len(word2)

        dp = [[-1 for _ in range(tn)] for _ in range(sn)]
        return self.func(word1, word2, sn-1, tn-1, dp)
    
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