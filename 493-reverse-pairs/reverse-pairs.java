class Solution {
    // https://leetcode.com/problems/reverse-pairs/
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // return f(nums,0,nums.length-1)-1;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        count += merge(nums, left, mid, right);
        return count;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        int[] temp = new int[right - left + 1];
        int i = left, k = mid + 1, t = 0;
        while (i <= mid && k <= right) {
            if (nums[i] <= nums[k]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[k++];
            }
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (k <= right) {
            temp[t++] = nums[k++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
        return count;
    }

    // ====


        // recursion
        // explore all possibilities
        // TC: O (2 ^ N)
        public int f(int[] nums, int i, int j) {

            if (i > j) {
                return 1;
            }

            int pairs = 0;
            pairs += f(nums, i + 1, j);
            
            for (int k = i + 1; k <= j; k++) {
                int e1 = nums[i];
                int e2 = nums[k];

                boolean satisfiesCondition = e1/e2 > 2L;

                if (satisfiesCondition) {
                    pairs++;
                }
            }


            return pairs;

        }
}