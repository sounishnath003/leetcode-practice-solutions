// https://leetcode.com/problems/4sum-ii/
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int answer = 0;
​
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
​
        for (int a : nums3) {
            for (int b : nums4) {
                int sum = a + b;
​
                if (map.containsKey(-1*sum)) {
                    answer += map.get(-1*sum);
                }
            }
        }
​
        return answer;
    }
}
