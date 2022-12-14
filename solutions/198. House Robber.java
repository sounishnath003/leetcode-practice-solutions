class Solution {
    public int rob(int[] nums) {
        /*
         * dp[i] = maxof(dp[i-1], profit[i]+d[i-2])
         */
        int MIN_LIMIT = (Integer.MIN_VALUE - 1);
        int n = nums.length;
        if (n <= 2) {
            if (n == 1)
                return nums[0];
            return maxof(nums[0], nums[1]);
        }
​
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = maxof(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int consider = dp[i - 2] + nums[i];
            int notconsider = dp[i - 1];
            dp[i] = maxof(consider, notconsider);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
​
    private int maxof(int... arr) {
        // TODO Auto-generated method stub
        return Arrays.stream(arr).max().getAsInt();
    }
}
​
