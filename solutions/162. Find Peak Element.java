class Solution {
    public int findPeakElement(int[] nums) {
        
        // Quick implementation of BinarySearch,
        // as it needs to be solved in O(LogN)
        
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
