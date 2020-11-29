class Solution {
    public int coinChange(int[] coins, int amount) {
           int n = coins.length;
    
    int dp[] = new int[amount + 1];    
     dp[0] = 0;        //  amount = 0 can be made by excuding every coin
    if(amount > 0 && coins == null) return 0;
     for(int i = 1; i <= amount; i++) {
        dp[i] = 100000;       // if no coin is available we return a large number or infinity
    }
    
    for(int i = 1; i <= n; i++) {
        for(int j = coins[i-1]; j <= amount; j++) {
            if(j >= coins[i-1]) {
                dp[j] =  Math.min(1 + dp[j-coins[i-1]], dp[j]);  // minimum of (Include , Exclude)
            } else { 
                dp[j] = dp[j];  // else exlude the current coin 
            }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
    }
}
