class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int reach = 0, lastPoint = 0, minSteps = 0;
        // think like if my current jump cannot reach the current i
        // I have to increase my steps
        for (int i = 0; i < n && i <= reach; i++) {
            if (i > lastPoint) {
                minSteps++;
                lastPoint = reach;
            }
            reach = Math.max(reach, nums[i] + i);
        }
        return (reach < n - 1) ? 0 : minSteps;
    }
}
