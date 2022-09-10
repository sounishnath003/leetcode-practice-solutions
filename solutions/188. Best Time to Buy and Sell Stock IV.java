class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k==0||n==0) return 0;
        if(k >= n/2){
            //it same as infinite tries
            int maxProfit = 0;
            for(int i=0;i<n-1;i++){
                //means either we dont buy or sell or buy today sell Tomorrow
                maxProfit = maxProfit + Math.max(0,prices[i+1]-prices[i]);
            }
            return maxProfit;
        }
        
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy,Integer.MIN_VALUE);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                //j==0 sybolises that this is our fisrst txn
                //sell[j-1] - prices[j]: means the money we have from last txn - prices of stock today
                buy[j] = Math.max(buy[j],j==0?0-prices[i]:sell[j-1]-prices[i]);
                sell[j] = Math.max(sell[j],buy[j]+prices[i]);
                //Max of either we don't do any thing or we make profit today
            }
        }
        return sell[k-1];   
    }
}
