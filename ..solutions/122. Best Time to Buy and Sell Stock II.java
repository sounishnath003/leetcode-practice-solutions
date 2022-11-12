class Solution {
    public int maxProfit(int[] arr) {
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
}
