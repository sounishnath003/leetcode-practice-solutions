class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0;
        for (int x : nums){
            if(x == 0) zero++;
            if(x == 1) one++;
        }
        int i = 0;
        while(zero-- > 0)
            nums[i++] = 0;
        while(one-- > 0)
            nums[i++] = 1;
        while(i < nums.length)
            nums[i++] = 2;
    }
}
