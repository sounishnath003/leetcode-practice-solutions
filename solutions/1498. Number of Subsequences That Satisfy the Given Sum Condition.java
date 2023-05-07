import java.util.Arrays;
​
class Solution {
    private final int MOD = (int) (1e9 + 7);
​
    public int numSubseq(int[] nums, int target) {
        // https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
        int n = nums.length;
        Arrays.sort(nums);
​
        int left = 0;
        int right = n - 1;
​
        int[] powers = new int[n+1];
        for (int i = 0; i < powers.length; i++) {
            if (i==0) {
                powers[i]=1;
            } else {
                powers[i] = (int) (powers[i-1] * 2) % MOD;
            }
        }
​
        int results = 0;
​
        while (left <= right) {
            int v1 = nums[left];
            int v2 = nums[right];
            int sum = v1 + v2;
​
            if (sum <= target) {
                int totalElems = (right - left);
                results += (powers[totalElems] % MOD);
                left++;
            } else {
                right--;
            }
        }
​
        return results;
    }
}
