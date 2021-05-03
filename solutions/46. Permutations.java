class Solution {
    /*
        Question is fairly very Simple!
        just traverse array and swap (i, curIndex) and backtrack
    */
    private List<List<Integer>> ans = new ArrayList<>(); 
    public List<List<Integer>> permute(int[] nums) {
        f(nums, 0);
        return ans;
    }
    private void f(int[] nums, int curIndex) {
        if(curIndex == nums.length - 1){
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            ans.add(list);
            return;
        }
        
        for(int i = curIndex; i < nums.length; i++) {
            {
                int t = nums[curIndex];
                nums[curIndex] = nums[i];
                nums[i] = t;
            }
            f(nums, curIndex+1);
            {
                int t = nums[curIndex];
                nums[curIndex] = nums[i];
                nums[i] = t;
            }
        }
    }
}
