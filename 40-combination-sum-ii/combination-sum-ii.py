# https://leetcode.com/problems/combination-sum-ii/

from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def solve(arr, i, current, ssf, target):
            if ssf == target:
                result.append(current[:])
                return
            if ssf > target or i == len(arr):
                return
            
            for j in range(i, len(arr)):
                if j > i and arr[j] == arr[j - 1]:
                    continue
                current.append(arr[j])
                solve(arr, j + 1, current, ssf + arr[j], target)
                current.pop()

        # we need to sort the candidates as it is asked to 
        # use the numbers only once.
        candidates.sort()

        solve(candidates, 0, [], 0, target)
        return result
