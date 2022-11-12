class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return this.containsNearbyDuplicate(nums, k, 0);
    }
​
    private boolean easyWithHashMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // <val, index>
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            // check if val present in map
            if (map.containsKey(val)) {
                int diff = Math.abs(map.get(val) - i);
                if (diff <= k) {
                    return true;
                }
            }
​
            map.put(val, i);
        }
        return false;
    }
​
    private boolean containsNearbyDuplicate(int[] nums, int k, int curindex) {
        if (curindex >= nums.length)
            return false;
​
        for (int i = curindex + 1; i < curindex + k + 1; i++) {
            if (i >= nums.length) break;
            int e1 = nums[curindex];
            int e2 = nums[i];
            if (e1 == e2)
                return true;
        }
​
        boolean rres = this.containsNearbyDuplicate(nums, k, curindex + 1);
        if (rres)
            return true;
​
        return false;
    }
}
