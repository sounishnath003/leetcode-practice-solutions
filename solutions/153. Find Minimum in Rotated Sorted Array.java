class Solution {
    // TC: O(N log N)
    // SC: O(1)
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        
        int gmin=Integer.MAX_VALUE;
        
        while (low <= high) {
            int mid=(low+(high-low)/2);
            
            // check if low <= high; entire half is sorted
            if (nums[low] <= nums[high]) {
                gmin=Math.min(gmin, nums[low]);
                break;
            }
            
            if (nums[low] <= nums[mid]) {
                gmin=Math.min(gmin, nums[low]);
                low=mid+1;
            } else {
                gmin=Math.min(gmin, nums[mid]);
                high=mid-1;
            }
        }
        
        return gmin;
    }
}
