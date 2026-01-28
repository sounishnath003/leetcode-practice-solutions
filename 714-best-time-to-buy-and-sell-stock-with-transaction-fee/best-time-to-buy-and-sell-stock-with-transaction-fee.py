class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        def fn(i, buy, dp):
            if i == len(prices):
                return 0
            
            if (i, buy) in dp:
                return dp[(i, buy)]

            profit = 0
            if buy:
                op1 = -prices[i] + fn(i+1, False, dp)
                op2 = fn(i+1, True, dp)
                profit = max(op1, op2)
            else:
                op1 = +prices[i] + fn(i+1, True, dp) - fee
                op2 = fn(i+1, False, dp)
                profit = max(op1, op2)

            dp[(i,buy)] = profit
            return profit

        return fn(i=0, buy=True, dp={})
            