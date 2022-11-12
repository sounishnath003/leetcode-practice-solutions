class Solution {
    public int findMaxLength(int[] nums) {
        return getMaxWindow(nums);
    }
    
    // TC-O(N), SC: O(N)
    public int getMaxWindow(int[] arr) {
        final int n = arr.length;
        int maxWindowLength = 0; // (higherIndex - lowerIndex + 1)
        int runningSum = 0;
​
        Map<Integer, Integer> seen = new HashMap<>(); // stores the runningSum indices
        seen.put(0, -1); // dummy value for initialization
​
        for (int index = 0; index < n; index++) {
            int elem = arr[index];
​
            runningSum = getRunningSum(runningSum, elem);
            maxWindowLength = updateTheWindowLength(maxWindowLength, runningSum, seen, index);
        }
​
        return maxWindowLength;
    }
​
    private int updateTheWindowLength(int maxlength, int runningSum, Map<Integer, Integer> seen, int index) {
        if (seen.containsKey(runningSum) == false) {
            seen.put(runningSum, index);
        } else {
            int alreadyPresentedLowerIndex = seen.get(runningSum);
            int windowLength = index - alreadyPresentedLowerIndex;
            maxlength = Math.max(maxlength, windowLength);
        }
        // System.out.println("running sum: " + runningSum + ", window Len so far: " + maxlength);
        return maxlength;
    }
​
    private int getRunningSum(int runningSum, int elem) {
        if (elem == 0) {
            runningSum++;
        } else runningSum--;
        return runningSum;
    }
​
}
