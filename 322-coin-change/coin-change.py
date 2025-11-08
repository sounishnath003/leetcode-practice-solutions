# LC: 322 Coin Change
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        """returns the minimum number of coins required to match the amount"""
        dp = {}
        def f(i:int, amount:int) -> int:
            nonlocal dp

            if amount < 0 or i < 0: return float("inf")
            if amount == 0: return 0
            if i == 0:
                if amount % coins[0] == 0: return amount//coins[0]
            if (i, amount) in dp: return dp[(i, amount)]
            # few options
            op1 = 1 + f(i, amount-coins[i])
            op2 = f(i-1, amount)

            dp[(i,amount)] =  min(op1, op2)
            return dp[(i,amount)]

        dp = [float("inf")] * (amount +1)
        for amt in range(amount+1):
            dp[amt] = amt//coins[0] if amt%coins[0]==0 else float("inf")

        for amt in range(amount+1):
            for coin in coins:
                if amt < coin: continue
                dp[amt] = min(1+dp[amt-coin], dp[amt])


        x = dp[amount]
        return x if x != float("inf") else -1
