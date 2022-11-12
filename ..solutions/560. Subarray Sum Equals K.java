class Solution {
    public int subarraySum(int[] nums, int k) {
        final int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int cursum = 0;
        int countOfSubarray = 0;
        
        for (int i = 0; i < n; i++) {
            int elem = nums[i];
            
            cursum += elem;
            
            if (cursum == k) {
                countOfSubarray++;
            }
            
            int diff = cursum - k;
            if (map.containsKey(diff)==true) {
                countOfSubarray += map.get(diff) ;
            }
            
            map.put(cursum, map.getOrDefault(cursum, 0) + 1);
        }
        
        return countOfSubarray;
    }
}
