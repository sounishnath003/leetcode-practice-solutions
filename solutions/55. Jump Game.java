class Solution {
    public boolean canJump(int[] nums) {
        /*
         * f(n) --> f(n-1) + possibilities possibilities -> (j + 0...arr[n-1]) can reach
         * n?
         */
​
        int maxjump = 0;
        for (int i = 0; i <= maxjump; i++) {
            maxjump = Math.max(maxjump, i + nums[i]);
            if (maxjump >= nums.length-1)
                return true;
        }
        return false;
    }
​
    private boolean func(int[] nums, int curindex) {
        // TODO Auto-generated method stub
        if (curindex >= nums.length - 1)
            return true;
​
        int jumpCount = nums[curindex];
        if (jumpCount == 0)
            return false;
​
        for (int j = 1; j <= jumpCount; j++) {
            int nextidx = curindex + j;
            boolean ans2 = func(nums, nextidx);
            if (ans2)
                return ans2;
        }
​
        return false;
    }
}
​
