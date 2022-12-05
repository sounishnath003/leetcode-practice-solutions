class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        return Math.max(func(nums, 1, nums.length), func(nums, 0, nums.length - 1));
    }
​
    private int func(int[] nums, int i, int length) {
        // TODO Auto-generated method stub
        int[] arr = Arrays.copyOfRange(nums, i, length);
        // System.out.println(Arrays.toString(arr));
        return rob2(arr);
    }
​
    private int rob2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            if (n == 1)
                return nums[0];
            return Math.max(nums[0], nums[1]);
        }
​
        int MIN_LIMIT = (Integer.MIN_VALUE + 1);
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int consider = dp[i - 2] + nums[i];
            int nonconsider = MIN_LIMIT;
            for (int j = 0; j < i; j++) {
                nonconsider = Math.max(nonconsider, dp[j]);
            }
            dp[i] = Math.max(consider, nonconsider);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
​
}
​
