class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int peak = Integer.MIN_VALUE;
        
        if (n==1) return 0;
​
        // check the 0th index
        if (nums[0] > nums[1]) {
            peak = nums[0];
            return 0;
        }
​
        // check the nth index
        if (n - 2 >= 0 && nums[n - 1] > nums[n - 2]) {
            peak = nums[n - 1];
            return n-1;
        }
​
        // time to confirm the intuition
        int low = 1;
        int high = n - 2;
​
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            // is peak
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                peak = mid;
                return peak;
            } else if (nums[mid] > nums[mid-1]) {
                low = mid+1;
            } else {
                high=mid-1;
            }
        }
​
        return -1;
    }
}
