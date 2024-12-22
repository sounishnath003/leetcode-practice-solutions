class Solution {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int k = 2;
    // define the dp struct.
    int[][][] dp = new int[n + 1][2][3];
    // fill the junk values for memoization.
    for (int row[][]: dp)
      for (int ir[]: row) Arrays.fill(ir, -1);
    // base case cond.
    dp[0][1][0] = 0;
​
    return recursive(prices, 0, 1, 2, dp);
  }
​
  public int recursive(int[] prices, int i, int buy, int transaction, int[][][] dp) {
    // base conds.
    if (i == prices.length) {
      return 0;
    }
    if (transaction == 0) {
      return 0;
    }
    if (dp[i][buy][transaction] != -1) {
      return dp[i][buy][transaction];
    }
​
    // options
    int op1 = 0, op2 = 0, op3 = 0;
​
    // if asked to buy, i need to buy the current cost or do thing (skip)
    if (buy == 1) {
      // i am paying from my pocket
      // buy the stock
      // skip the stock
      op1 = Math.max(
        -prices[i] + recursive(prices, i + 1, 0, transaction, dp),
        recursive(prices, i + 1, 1, transaction, dp));
    } else {
      // i need to sell,
      op2 = prices[i] + recursive(prices, i + 1, 1, transaction - 1, dp);
      // or do not do anything
      op3 = recursive(prices, i + 1, 0, transaction, dp);
    }
​
    int profit = Math.max(op1, Math.max(op2, op3));
    dp[i][buy][transaction] = profit;
    return profit;
  }
}
