# https://leetcode.com/problems/combination-sum-ii/

from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        results=[]

        def solve(arr, i, current, ssf, target):
            nonlocal results
            if ssf == target:
                results.append(current[:])
                return 
            if i == len(arr) or ssf > target:
                return 0
            
            n=len(arr)
            for j in range(i, n):
                if j>i and arr[j] == arr[j-1]:
                    continue
                current.append(arr[j])
                f=solve(arr,j+1,current,ssf + arr[j], target)
                current.pop()

        # we need to sort the candidates as it is asked to 
        # use the numbers only once.
        candidates.sort()

        solve(candidates,0,[],0,target)
        return results
