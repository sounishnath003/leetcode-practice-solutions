class Solution:
    def maxSatisfaction(self, arr: List[int]) -> int:
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
