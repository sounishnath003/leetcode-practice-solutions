class Solution {
    public int missingNumber(int[] nums) {
        /**
            naive approch is to just sort and check
            with nums[0] == 0 ? nums[0] - 1 : nums[len-1] + 1;
        
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i-1];
            if (gap>1) 
                return nums[i-1] + 1;
        }
        if(nums[0] != 0) return nums[0] - 1;
        return nums[nums.length-1] + 1;
        */
        
        int x1 = 0, x2 = 0;
        for (int i = 0; i < nums.length; i++) {
            x1 = x1 ^ nums[i];
            x2 = x2 ^ (i+1);
        }
        return x1 ^ x2;
    }
}
