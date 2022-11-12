class Solution {
    public int triangleNumber(int[] nums) {
        /*
         * Method 1: Sort the array in ascending order. For each element, we check if
         * there are two other elements that can form a triangle. If yes, then we
         * increment the count. Time Complexity: O(n^2) Space Complexity: O(1)
         * 
         * Method 2: Sort the array in ascending order. For each element, we check if
         * there are two other elements that can form a triangle. If yes, then we
         * increment the count. Time Complexity: O(nlogn) Space Complexity: O(1)
         */
​
        Arrays.sort(nums);
        int count = 0;
​
        // lovely tweaked BinarySearch problem.
        // we can use BinarySearch to find the index of the first element that is
        // greater than the sum of the two other elements.
​
        for (int i = nums.length - 1; i > -1; i--) {
            int lo = 0;
            int r = i-1;
​
            while (lo < r) {
                int sumOfTwoSide = nums[lo] + nums[r];
                if (sumOfTwoSide > nums[i]) { // ami bhebhechilam == hoy, kintu strictly greater than hobe!
                    count += r - lo;
                    r--;
                } else {
                    lo++;
                }
            }
        }
​
        return count;
    }
}
