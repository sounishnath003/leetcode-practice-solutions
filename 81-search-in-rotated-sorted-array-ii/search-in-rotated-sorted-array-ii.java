class Solution {

    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    public boolean search(int[] arr, int target) {
        // total length of the arr
        int n = arr.length;
        // defining the search space range
        int low = 0;
        int high = n - 1;
        // perform binary search
        while (low <= high) {
            // get the mid
            int mid = low + (high - low) / 2;
            // best case condition
            if (arr[mid] == target) {
                // lowest index
                while (mid >= 0 && arr[mid] == target)
                    mid--;
                // return the mid index
                return true;
            }
            
                        //Edge case:
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            
            // else there would be some conditions
            // that we have to follow up and implement
            // find the sorted part
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

}