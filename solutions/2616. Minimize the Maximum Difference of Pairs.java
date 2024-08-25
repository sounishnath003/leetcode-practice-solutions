class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        /**
         * simply binary search problem
         * as MIN MAX problem
         * 
         * same like the aggresive cows - modified version
         */
​
        // sort the array
        Arrays.sort(nums); // as we need to perform binary searchh
        // the maximum pair difference will be the smallest element
        // and largest element in the array
​
        // so my serach space is (0.....(lar-small))
        int low = 0;
        int high =  (nums[nums.length - 1] - nums[0]);
        // iterate on the search space and find the sweet spot of having P pairs
        int ans=0;
        while (low <= high) {
            int possibleDiff = (low + (high - low) / 2);
            // check my possibleDiff has atleast P paris
            boolean hasPPairs = countOfPairsAtleastP(nums, possibleDiff, p);
            // if you found ; then try to minimise the search space by HIGH = MID - 1
            if (hasPPairs) {
                high = possibleDiff - 1;
                ans=possibleDiff;
            } else {
                low = possibleDiff + 1;
            }
            // if not increase the lower bound
        }
        // ans will be the minimal maximum difference
        return ans;
    }
​
    private boolean countOfPairsAtleastP(int[] nums, int diff, int p) {
        int countPairs = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (absoluteDifference(nums[i], nums[i + 1]) <= diff) {
                countPairs++;
                i += 2;
            } else {
                i++;
            }
​
            if (countPairs == p) {
                return true;
            }
        }
        return false;
    }
​
    // return the absolute diff of a and b elem
    private int absoluteDifference(int a, int b) {
        return Math.abs(a - b);
    }
}
