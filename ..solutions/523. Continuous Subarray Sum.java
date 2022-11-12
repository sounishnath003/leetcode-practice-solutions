class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        return this.optimized(nums, k);
    }
​
    private boolean optimized(int[] nums, int k) {
        /**
         * as this is a continuos subarray we can leverage prefix sum concept
         * map = {0, -1};
         * prefixsum += arr[i] % k;
         * map.put(prefixsum, i);
         * if (map.contains prefixsum && prefixsum == 0) return true with i -
         * map[predixsum] >= 2;
         */
​
        int n = nums.length;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // <sum, index>
        map.put(0, -1); // {special case to conform the check}
​
        for (int i = 0; i < n; i++) {
            prefixSum = (prefixSum + nums[i]) % k;
            if (map.containsKey(prefixSum)) {
                int start = map.get(prefixSum);
                int windowsize = i - start;
                if (windowsize >= 2) {
                    return true;
                }
            } else {
                map.put(prefixSum, i);
            }
        }
​
        // if (map.containsKey(prefixSum)) {
        //     int start = map.get(prefixSum);
        //     int windowsize = n - start;
        //     if (windowsize >= 2) {
        //         return true;
        //     }
        // }
​
        return false;
    }
​
    private boolean bruteforoce(int[] nums, int k) {
        int n = nums.length;
        boolean isFound = false;
​
        for (int i = 0; i < n; i++) {
            int cursum = nums[i];
            boolean _isFound = false;
            for (int j = i + 1; j < n; j++) {
                cursum += nums[j];
                int windowlength = j - i + 1;
                if (windowlength >= 2 && (cursum % k) == 0) {
                    _isFound = true;
                    break;
                }
            }
            if (_isFound) {
                isFound = true;
                break;
            }
        }
​
        return isFound;
    }
}
