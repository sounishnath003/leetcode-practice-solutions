class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res, sol = [], []
        
        def backtrack(i:int, cursum:int):
            if cursum == target:
                res.append(sol.copy())
                return

            if cursum > target or i == len(nums):
                return

            # i could skip the number
            backtrack(i+1, cursum)
            # or take as many times as i need
            sol.append(nums[i])
            backtrack(i, cursum + nums[i])
            sol.pop()

        backtrack(0,0)

        return res
