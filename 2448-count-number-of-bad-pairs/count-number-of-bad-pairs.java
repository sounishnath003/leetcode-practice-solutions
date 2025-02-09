class Solution {

    // https://leetcode.com/problems/count-number-of-bad-pairs/
    public long countBadPairs(int[] nums) {
        Map<Long, Long> map = new HashMap<>(); // < nums[i] - i, count >

        /**
         * good pair condition:
         * j - i === nums[j] - nums[i]
         * 
         * j - nums[j] = i - nums[i]
         */

        long totalPairs = 0;
        long goodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            long e = 1L * nums[i];
            totalPairs += i;
            if (map.containsKey(i-e)) {
                goodPairs += map.get(i-e);
            }
            map.put(i-e, map.getOrDefault(i-e, 0L) + 1L);
        }

        return totalPairs - goodPairs;
    }

    public long bruteForceWay(int[] nums) {
        // get the length
        int n = nums.length;
        // a bad pair if i < j and j - i != nums[j] - nums[i].
        // iterate on the array
        int badPairs = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int e1 = nums[i];
                int e2 = nums[j];

                if (j - i != (e2 - e1))
                    badPairs++;
            }
        }
        return badPairs;
    }

}