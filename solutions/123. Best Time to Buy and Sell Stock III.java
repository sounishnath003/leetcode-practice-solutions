class Solution {
    public int maxProfit(int[] prices) {
        int buyAtFirst = Integer.MAX_VALUE;
        int profitForFirstTransaction = 0;
        
        int buyAtSecond = Integer.MAX_VALUE;
        int profitForSecondTransaction = 0;
        
        for (int i = 0; i < prices.length; i++) {
            // ------ FOR 1st Trans -------
            int todayPrice = prices[i];
            if (todayPrice < buyAtFirst) {
                buyAtFirst = todayPrice;
            }
            int profit = todayPrice - buyAtFirst;
            profitForFirstTransaction = Math.max(profitForFirstTransaction, profit);
            // ------ FOR 2nd Trans -------
            int extraMoneyHaveToSpend = todayPrice - profitForFirstTransaction;
            if (extraMoneyHaveToSpend < buyAtSecond)
                buyAtSecond = extraMoneyHaveToSpend;
            
            int anotherProfit = todayPrice - buyAtSecond;
            if (anotherProfit > profitForSecondTransaction)
                profitForSecondTransaction = anotherProfit;
        }
        
        return profitForSecondTransaction;
    }
}
