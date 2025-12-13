class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        def f(i, T):
            if T == 0: return 1 
            if i == 0: return 1 if T % coins[0] == 0 else 0

            # pick or not pick
            op1 = f(i-1, T)
            op2 = f(i, T - coins[i]) if T >= coins[i] else 0

            return op1 + op2
    
        n = len(coins)
        dp = [[0] * (amount + 1) for _ in range(n)]

        # base case: using only coins[0]
        for amt in range(amount + 1):
            dp[0][amt] = 1 if amt % coins[0] == 0 else 0

        for i in range(1, n):
            for amt in range(amount + 1):
                not_pick = dp[i - 1][amt]
                pick = dp[i][amt - coins[i]] if amt >= coins[i] else 0
                dp[i][amt] = not_pick + pick

        return dp[n - 1][amount]