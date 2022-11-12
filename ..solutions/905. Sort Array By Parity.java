class Solution {
    public int[] sortArrayByParity(int[] nums) {
        /**
         * move all even numbers into beginning and odd to right half of the arr
         */
        int j = 0;
​
        for (int i = 0; i < nums.length; i++) {
            // if odd
            if (nums[i] % 2 == 1) {
​
            } else {
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
                j++;
            }
        }
        return nums;
    }
}
