MAX_LIMIT=int(1e8)

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        global MAX_LIMIT
        n = len(nums)

        left_prefix_prod=1
        right_prefix_prod=1

        global_max_prod=-1 * MAX_LIMIT

        for i in range(n):
            le = nums[i]
            re = nums[n-i-1]

            if left_prefix_prod == 0:
                left_prefix_prod = 1
            
            if right_prefix_prod == 0:
                right_prefix_prod = 1

            left_prefix_prod = left_prefix_prod * le
            right_prefix_prod = right_prefix_prod * re


            global_max_prod = max(global_max_prod, max(left_prefix_prod, right_prefix_prod))

        return global_max_prod