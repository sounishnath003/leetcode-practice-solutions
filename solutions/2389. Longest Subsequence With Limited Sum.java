class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        /*
         * 1. more logical if we pick the smallest elements i.e. the window length will
         * become longest 2. sort the nums array, and as it is subsequence so the
         * original ordering does not matter too much. 3. do the precomputation of
         * prefixsum[i] = sum(arr[0...i]) and you get the max elements 4. do the lower
         * bound binary search to get the right index from prefix sum. 5.
         */
​
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefixsum = calculatePrefixSum(nums, n);
        System.out.println("prefix = " + Arrays.toString(prefixsum));
​
        int qn = queries.length;
        int[] result = new int[qn];
        for (int i = 0; i < qn; i++) {
            int query = queries[i];
            int upperIndex = binarySearch(prefixsum, query);
            result[i] = upperIndex;
        }
​
        return result;
    }
​
    private int binarySearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > target) {
                hi=mid;
            } else {
                lo=mid+1;
            }
        }
​
        return lo;
    }
​
    private int[] calculatePrefixSum(int[] nums, int n) {
        int[] prefixsum = new int[n];
        prefixsum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixsum[i] += prefixsum[i - 1] + nums[i];
        }
        return prefixsum;
    }
}
​
