class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int gmax=0;
        // currentCount 
        int currentCount=0;
        // iterate over and count
        for (int i=0; i<n; i++) {
            int e=nums[i];
            if (e != 1) {
                gmax=Math.max(gmax, currentCount);
                currentCount=0;
            } else {
                ++currentCount;
            }
        }
        // check for the last option was an 1
        gmax=Math.max(gmax, currentCount);
        
        return gmax;
    }
}
