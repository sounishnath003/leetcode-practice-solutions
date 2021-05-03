class Solution {
    public int[] runningSum(int[] nums) {
        /*
            Whatever it is -- running sum
            The concept is only adding prefixSum[i-1] + currentElem of the array
            and return the prefixSum[];
        */
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            prefixSum[i] += nums[i] + prefixSum[i-1];
        return prefixSum;
    }
}
