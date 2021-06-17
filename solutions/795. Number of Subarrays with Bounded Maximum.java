class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = 0;
        int end = 0;
        int answer = 0;
        int wc = 0;
​
        while (end < nums.length) {
            if (nums[end] >= left && nums[end] <= right) {
                // means in range
                wc = end - start + 1;
            } else if (nums[end] > right) {
                // means right overflowed
                wc = 0; // reset window
                start = end + 1;
            } else if (nums[end] < left) {
                // means left underflowed
            }
            
            answer += wc;
            end++;
        }
​
        return answer;
    }
}
