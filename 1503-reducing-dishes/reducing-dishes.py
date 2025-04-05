# https://leetcode.com/problems/reducing-dishes/description/

from typing import List

class Solution:
    def maxSatisfaction(self, arr: List[int]) -> int:
        """recursion formula was: simply"""
        # get the length
        n = len(arr)
        if n == 0:
            return 0
            
        # sort the input arr to increasing the time co-efficient
        arr.sort()
        
        # define dp (n+1 x n+1) 
        dp = [[0 for _ in range(n+2)] for _ in range(n+1)]
        
        # iterate over the arr from end
        for i in range(n-1, -1, -1):
            for time in range(1, n+1):
                # max of not picking current dish vs picking it
                dp[i][time] = max(
                    dp[i+1][time],  # not pick
                    arr[i] * time + dp[i+1][time+1]  # pick current dish
                )
                
        return max(0, dp[0][1])  # return max of 0 and result starting from first dish
       
    def maxSatisfactionRec(self, arr: List[int]) -> int:
        """we can apply pick and not pick concept"""
        def f(i, time, dp=None):
            if i == len(arr):
                return 0
            if (i, time) in dp:
                return dp[(i, time)]
            # not pick
            notp = 0 + f(i + 1, time, dp)
            # pick
            pick = (time * arr[i]) + f(i + 1, time + 1, dp)

            dp[(i, time)] = max(notp, pick)
            return dp[(i, time)]

        dp = {}
        arr.sort()
        return f(0, 1, dp)
