class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return optimized(nums);
    }
​
    private List<List<Integer>> optimized(int[] nums) {
        // TC: O(NLogN+N**2) ; SC: O(M)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -1 * nums[i];
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {
                int sm = nums[start] + nums[end];
                if (sm == target) {
                    result.add( Arrays.asList(nums[i], nums[start], nums[end]) );
                    while (start+1 < nums.length && nums[start+1] == nums[start]) start++;
                    while (end-1 > 0 && nums[end-1] == nums[end]) end--;
                    start++;
                    end--;
                }
                else if (sm > target) {
                    end--;
                } else {
                    start++;
                }
            }
            while (i+1 < nums.length && nums[i+1] == nums[i]) i++;
        }
        return result;
    }
​
    private List<List<Integer>> bruteforce(int[] nums) {
        // TC: O(N**3) ; SC: O(N)
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(sorted(nums[i], nums[j], nums[k] ));
                    }
                }
            }
        }
        return result.stream().toList();
    }
