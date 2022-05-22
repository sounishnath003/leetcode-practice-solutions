class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=0;
        int cumlength=0;
        int maxlength=0;
​
        while (end<n) {
            int elem=nums[end];
            if (elem==1) {
                ++cumlength;
            } else {
                maxlength=Math.max(maxlength,cumlength);
                // System.out.println("CUML="+cumlength+" START="+start+" END="+end);
                start=end;
                cumlength=0;
            }
            end++;
        }
        maxlength=Math.max(maxlength,cumlength);
        return maxlength;
    }
}
