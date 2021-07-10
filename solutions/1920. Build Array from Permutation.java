class Solution {
    public int[] buildArray(int[] nums) {
        final int n = nums.length;
        int[] ans = new int [n];
​
        int i = 0;
        for (int index : nums) {
            ans[i] = nums[index];
            i++;
        }
        
        return ans;
    }
}
