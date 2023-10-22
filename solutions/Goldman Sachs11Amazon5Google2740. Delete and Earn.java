class Solution {
    private int MOD = 1000000007;
​
    public int deleteAndEarn(int[] nums) {
        /**
         * 1. maximise the points
         * 2. operations:
         * 2.1. nums[i] pick any, and delete. score += nums[i]
         * 2.2. after that, delete, nums[i] - 1 and nums[i] + 1.
         * 
         * [3,4,2]
         * 3 --- 2x 4x -- [_,_,_]
         * 2 --- 1x 3x -- [_,4,_] ---> (2+4) --> 6
         * 4 --- 3x 5x -- [_,_,2] ---> (4+2) --> 6
         * 
         * [2,2,3,3,3,4]
         * [_,_,_,3,3,_] 3
         * [_,_,_,_,3,_] 3+3=6
         * [_,_,_,_,_,_] 6+3=9 **** highest ****
         **/
​
        int included = 0;
        int excluded = 0;
        int[] countFrequency = new int[100000];
​
        for (int i = 0; i < nums.length; i++) {
            countFrequency[nums[i]]++;
        }
​
        for (int i = 0; i < countFrequency.length; i++) {
            int ninclude = excluded + countFrequency[i] * i;
            int nexclude = Math.max(excluded, included);
​
            included = ninclude;
            excluded = nexclude;
        }
​
        return Math.max(included, excluded);
​
    }
}
