class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(nums, permutations, 0);
        return permutations;
    }
​
    private void permute(int[] nums, List<List<Integer>> permutations, int currentIndex) {
        // TODO Auto-generated method stub
        if (nums.length == currentIndex) {
            permutations.add(toList(nums));
            return;
        }
​
        for (int i = currentIndex; i < nums.length; i++) {
            swap(nums, currentIndex, i);
            permute(nums, permutations, currentIndex + 1);
            swap(nums, currentIndex, i);
        }
    }
​
    private List<Integer> toList(int[] nums) {
        // TODO Auto-generated method stub
        List<Integer> list = new ArrayList<>();
        for (int x : nums)
            list.add(x);
        return list;
    }
​
    private void swap(int[] nums, int currentIndex, int i) {
        // TODO Auto-generated method stub
        int t = nums[currentIndex];
        nums[currentIndex] = nums[i];
        nums[i] = t;
    }
}
​
