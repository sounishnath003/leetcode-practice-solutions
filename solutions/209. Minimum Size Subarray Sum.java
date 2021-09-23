class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result_size = Integer.MAX_VALUE;
​
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                result_size = 1;
                break;
            } else {
                sum += nums[i];
                while (sum >= target) {
                    result_size = Math.min(result_size, i - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
        }
​
        return result_size == Integer.MAX_VALUE ? 0 : result_size;
    }
}
