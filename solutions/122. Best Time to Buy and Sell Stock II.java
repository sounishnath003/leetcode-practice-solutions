class Solution {
     public int maxProfit2(int[] arr) {
         // BEST APPROACH::
         // EASY: O(N) solution
         // 
        final int n = arr.length;
        int overrallProfit = 0;
​
        for (int i = 1; i < n; i++) {
            int profit = arr[i] - arr[i-1];
            if (profit > 0) {
                overrallProfit += profit;
            }
        }
        
        return overrallProfit;
    }
    
    public int maxProfit(int[] prices) {
        // return recursive(prices, 0, true);
            int n = prices.length;
            int[][] dp = new int[n + 1][2];

            // base case n == prices.length
            dp[n][0] = dp[n][1] = 0;

            // fill the dp.
            for (int i = n - 1; i >= 0; i--) {
                for (int buy = 0; buy < 2; buy++) {
                    // buy : true
                    if (buy == 1) {
                        // Math.max((-1 * prices[i]) + recursive(prices, i + 1, false),
                        // recursive(prices, i + 1, true));
                        dp[i][buy] = Math.max(
                                (-1 * prices[i]) + dp[i + 1][0],
                                dp[i + 1][1]);
                    } else {
                        // sell : false
                        // if i sell, i will get the current price
                        // op2 = prices[i] + recursive(prices, i + 1, true);
                        // // if i skip, i will not get anything
                        // op3 = recursive(prices, i + 1, false);
                        dp[i][buy] = Math.max(
                                prices[i] + dp[i + 1][1],
                                dp[i + 1][0]);
                    }
                }
            }

            return dp[0][1];
    }
    
    public int recursive(int[] prices, int i, boolean askToBuy) {
            if (i == prices.length) {
                return 0;
            }

            int op1 = 0, op2 = 0, op3 = 0;
            // if asked to buy, i need to buy the current cost
            if (askToBuy) {
                // i am paying from my pocket
                op1 = Math.max((-1 * prices[i]) + recursive(prices, i + 1, false), recursive(prices, i+1, true));
            } else {
                // as single is -> i can sell or skip it
                // if i sell, i will get the current price
                op2 = prices[i] + recursive(prices, i + 1, true);
                // if i skip, i will not get anything
                op3 = recursive(prices, i + 1, false);
            }

            return Math.max(op1, Math.max(op2, op3));
    
    
    }
}
