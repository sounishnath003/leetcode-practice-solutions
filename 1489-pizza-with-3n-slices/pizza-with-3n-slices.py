class Solution:
    def maxSizeSlices(self, slices: List[int]) -> int:
        n = len(slices) // 3

        def solve(arr):
            m = len(arr)
            dp = [[[0] * (n + 1) for _ in range(m + 1)] for _ in range(2)]

            for i in range(1, m + 1):
                for j in range(1, n + 1):
                    # Don't take the current slice
                    dp[i % 2][i][j] = dp[(i - 1) % 2][i - 1][j]
                    # Take the current slice
                    if i >= 2:
                        dp[i % 2][i][j] = max(dp[i % 2][i][j], arr[i - 1] + dp[(i - 2) % 2][i - 2][j - 1])
                    elif i == 1 and j == 1:
                        dp[i % 2][i][j] = arr[i - 1]

            return dp[m % 2][m][n]

        # Consider two cases to break the circular dependency:
        # 1. The first slice is included, so the last cannot be.
        case1_slices = slices[:-1]
        result1 = solve(case1_slices)

        # 2. The first slice is excluded, so the last can be.
        case2_slices = slices[1:]
        result2 = solve(case2_slices)

        return max(result1, result2)
    
    
    def maxSizeSlicesRec(self, slices: List[int]) -> int:
        n = len(slices) // 3

        memo = {}

        def solve(index, count, taken):
            if count == n:
                return 0
            if index >= len(slices):
                return -float('inf')

            if (index, count, tuple(sorted(list(taken)))) in memo:
                return memo[(index, count, tuple(sorted(list(taken))))]

            # Option 1: Skip the current slice
            res = solve(index + 1, count, taken)

            # Option 2: Take the current slice if it's available
            if index not in taken:
                new_taken = set(taken)
                new_taken.add(index)
                # Mark Alice's and Bob's picks as taken (if within bounds)
                alice_pick = (index - 1 + len(slices)) % len(slices)
                bob_pick = (index + 1) % len(slices)
                new_taken.add(alice_pick)
                new_taken.add(bob_pick)
                res = max(res, slices[index] + solve(index + 1, count + 1, new_taken))

            memo[(index, count, tuple(sorted(list(taken))))] = res
            return res

        # We have two scenarios to consider due to the circular nature:
        # 1. We take the first slice.
        # 2. We don't take the first slice.
        # This breaks the circular dependency for the recursion.

        # Scenario 1: Assume we take the first slice (index 0)
        taken1 = {0, 1, len(slices) - 1} if len(slices) > 1 else {0}
        res1 = slices[0] + solve(1, 1, taken1)

        # Reset memo for the second scenario
        memo.clear()

        # Scenario 2: Assume we don't take the first slice (index 0)
        res2 = solve(1, 0, set())

        return max(res1, res2)