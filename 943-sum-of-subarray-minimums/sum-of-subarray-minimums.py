# LC: 907
# https://leetcode.com/problems/sum-of-subarray-minimums/description/
class Solution:
    def sumSubarrayMins(self, nums: list[int]) -> int:
        """
        1. Naive: O(N^2) ; SC: O(1)
            1. you can generate all subarrays - 
            2. check the minimum for all the subarrays
            3. sum them up
            4. return the total sum as result / answer

        2. Optimized: TC: O(N + N + N) = O(3N) ; SC: O(2N)
            1. Use of monotonic stack - means, keep the smaller elements only on the stack
            2. for any element, 
                2.1 check the next smaller elements (store the index)
                2.2 check the smaller previous smaller equal elements (store the index)
            3. simply, know the count the subarrays you can form using (R - L + 1) formula for that element.
            4. total += local_sum
            5. return the answer
        """

        def get_nses():
            stack = []
            nses = [len(nums)] * len(nums)
            for i in range(len(nums) - 1, -1, -1):
                while stack and nums[stack[-1]] > nums[i]: stack.pop()
                nses[i] = len(nums) if not stack else stack[-1]
                stack.append(i)

            return nses

        def get_psees():
            stack = []
            pses = [-1] * len(nums)
            for i in range(len(nums)):
                while stack and nums[stack[-1]] >= nums[i]: stack.pop()
                pses[i] = -1 if not stack else stack[-1]
                stack.append(i)

            return pses

        MOD = int(1e9+7)
        n = len(nums)
        nse = get_nses()
        psee = get_psees()

        total = 0
        for i in range(n):
            left_boundary, right_boundary = i - psee[i], nse[i] - i
            # left and right boundary provides the indexes .
            # to # subarray just substract from curr index
            # wrong formula: local_sum = (nums[i] * (left_boundary + right_boundary)) % MOD
            # we need to know, how many combination of subarray be formed with L and R counts
            local_sum = (left_boundary * right_boundary * nums[i]) % MOD
            total = (total + local_sum) % MOD

        return total
