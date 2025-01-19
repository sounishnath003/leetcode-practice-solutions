class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum=0;
        Map<Integer, Integer> map=new HashMap<>(); // <sum, freq>

        // default
        map.put(0,1);

        // result
        int totalSub=0;

        for (int elem : nums) {
            prefixSum += elem;
            int complement = prefixSum - k;
            if (map.containsKey(complement)) {
                totalSub += map.get(complement);
            }
            map.put( prefixSum, map.getOrDefault(prefixSum, 0) + 1 );
        }

        return totalSub;
    }
}