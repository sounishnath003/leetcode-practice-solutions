class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxprofit=0
        # setting base index as my current profit
        curr_stock=prices[0]
        for index, price in enumerate(prices):
            # if we buy this
            current_profit = price - curr_stock
            # calculate if i am getting max profit by selling today
            maxprofit=max(current_profit, maxprofit)
            # think if you would choose this stock only if it is at 
            # lower price than other days
            curr_stock=min(curr_stock, price)

        return maxprofit