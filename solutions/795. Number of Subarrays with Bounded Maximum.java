class Solution {
    // public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    
    // leetcode 795 https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int prev_count = 0;
        int overall_count = 0;
​
        int i = 0;
        int j = 0;
​
        while(j < nums.length) {
            if(left <= nums[j] && nums[j] <= right) {
                prev_count = j - i + 1;
                overall_count += prev_count;
            } else if(nums[j] < left) {
                overall_count += prev_count;
            } else {
                prev_count = 0;
                i = j + 1;
            }
            j++;
        }
        return overall_count;
    }
}
