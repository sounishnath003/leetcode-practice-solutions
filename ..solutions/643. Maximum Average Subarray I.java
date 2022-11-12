class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
​
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
​
        double res = sums[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sums[i] - sums[i - k]) * 1.0 / k);
        }
​
        return res;
        // int n = nums.length;
        // double max_avg = Double.MIN_VALUE;
​
        // for (int i = 0; i <= n - k; i++) {
        //     int[] temp = Arrays.copyOfRange(nums, i, i + k);
        //     int sum = 0;
        //     for (int elem : temp)
        //         sum += elem;
​
        //     double avg = sum / (k * 1.0);
        //     max_avg = Math.max(max_avg, avg);
        // }
​
        // return max_avg;
    }
}
