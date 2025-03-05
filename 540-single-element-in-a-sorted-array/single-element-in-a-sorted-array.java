class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) return nums[0];
        if (nums[n-1] != nums[n-2]) return nums[n-1];
        // even tho we have checked, still have to run from 1 extremes
        // other wise even check will failed with index not in bound.
        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = low + (high - low) /2;

            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];

            if (nums[mid] == nums[mid-1]) {
                // think where to go?
                int leftSideCount = (mid - low + 1);
                if (leftSideCount % 2 == 0) {
                    // if even we can not find the single non duplicated elem
                    low = mid + 1;
                } else {
                    high = mid - 2;
                }
            } else {
                int rightSideCount = (high - mid + 1);
                if (rightSideCount % 2 == 0) {
                    high = mid - 1;
                } else {
                    low = mid + 2;
                }
            }
        }

        return -1;
    }
}