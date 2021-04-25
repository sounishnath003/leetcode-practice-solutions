class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length;
        int min = arr[0];
        int max = arr[0];
        int ans = arr[0];
        
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                int t = min;
                min = max;
                max = t;
            }
            
            min = Math.min(arr[i], min * arr[i]);
            max = Math.max(arr[i], max * arr[i]);
            
            ans = Math.max(ans, max);
        }
        
        return ans;
    }
}
