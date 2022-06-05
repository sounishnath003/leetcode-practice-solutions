class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets=new ArrayList<>();
        List<Integer> set=new ArrayList<>();
        Arrays.sort(nums);
        func(nums,0,set,subsets);
        return subsets;
    }
​
    private void func(int[] nums, int i, List<Integer> set, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(set));
        for (int index=i; index< nums.length;index++){
           if (i!=index && nums[index] == nums[index-1]) continue;
           set.add(nums[index]);
           func(nums,index+1,set, subsets);
           set.remove(set.size()-1);
        }
    }
}
