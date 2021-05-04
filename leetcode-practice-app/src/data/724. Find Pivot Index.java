class Solution {
    public int pivotIndex(int[] nums) {
        /**
         * One simple solution will be count prefsum for whole arr[]; do check
         * rightpartsum[curindex+1] == prefsum[curindex-1];
         */
        int leftPartSum = 0;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++)
            runningSum += nums[i];
​
        for (int i = 0; i < nums.length; i++) {
            runningSum -= nums[i];
            if (leftPartSum == runningSum)
                return i;
            else leftPartSum += nums[i];
        }
        return -1;
    }
}
