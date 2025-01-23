class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // define 3 rd order dp
        int[][][] dp = new int[n + 1][2][3];

        for (int[][] row : dp) {
            for (int[] rr : row) {
                Arrays.fill(rr, -1);
            }
        }

        // preset value
        // i = 0, buy = 1, K = 0
        dp[0][1][0] = 0;

        return maxProfit(prices, 0, 1, 2, dp);
    }

    private int maxProfit(int[] stocks, int i, int buy, int K, int[][][] dp) {

        // base condn
        if (i == stocks.length || K == 0) {
            return 0;
        }

        if (dp[i][buy][K] != -1)
            return dp[i][buy][K];

        // if ask to buy, i can buy or do nothing
        if (buy == 1) {
            // as i am buying the money will go out from pocket, hence -ve
            int op1 = -stocks[i] + maxProfit(stocks, i + 1, 0, K, dp);
            // do nothing
            int op2 = maxProfit(stocks, i + 1, 1, K, dp);
            // return maximum of them
            return dp[i][buy][K] = Math.max(op1, op2);
        }

        // now asks for sell
        // i can sell or do nothing. as i have sold. one trasaction completed
        int op1 = stocks[i] + maxProfit(stocks, i + 1, 1, K - 1, dp);
        int op2 = maxProfit(stocks, i + 1, 0, K, dp);

        // return max
        return dp[i][buy][K] = Math.max(op1, op2);
    }
}