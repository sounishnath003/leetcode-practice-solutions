class Solution {
    public int removeDuplicates(int[] nums) {
        return optimized(nums);
    }
​
    private int optimized(int[] nums) {
        int n=nums.length;
        int left=-1;
        int right=0;
        while (right<n){
            int elem=nums[right];
            if (left==-1||nums[left] != nums[right])
                nums[++left]=nums[right];
            right++;
        }
        return left+1;
    }
}
