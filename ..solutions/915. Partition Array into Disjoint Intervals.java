class Solution {
    public int partitionDisjoint(int[] nums) {
        final int n = nums.length;
        
        int current_max = nums[0];
        int max = current_max;
        int partitioned_index = 0; // mentioned that index must exists!
        
        for (int i = 1; i < n; i++) {
            int elem = nums[i];
            
            if (current_max > elem) {
                current_max = max; // switch the maxi elem
                partitioned_index = i;
            } 
             else max = Math.max( max, elem );
        }
        
        partitioned_index++; // point is prev elem was the last elem of the first interval, (index+1) will be parition index.
        
        return partitioned_index;
    }
}
