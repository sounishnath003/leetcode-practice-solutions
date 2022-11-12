class Solution {
    public int largestPerimeter(int[] nums) {
         Arrays.sort(nums);
        
        int perimeter =0;
        
        for(int i=nums.length-1; i >= 2; i--){
            if(nums[i-1] + nums[i-2] > nums[i]){
                perimeter = nums[i] + nums[i-1] +nums[i-2];
                break;
            }
        }
        return perimeter;       
    }
}
