class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int maximumsum = arr[0];
        int runningSum = arr[0];
​
        for (int i = 1; i < n; i++) {
            runningSum += arr[i];
            if (runningSum > arr[i]) {
                maximumsum = Math.max(maximumsum, runningSum);  
            } else {
                runningSum = arr[i];
                maximumsum = Math.max(maximumsum, runningSum);
            }
        }
​
        return maximumsum;
    }
}
