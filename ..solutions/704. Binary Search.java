class Solution {
    public int search(int[] nums, int target) {
        int r = 0;
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi)/2;
            if (nums[mid]==target) return r = mid;
            else if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return -1;
    }
}
