class Solution {
    public int maxProduct(int[] nums) {
        // declare vars.
        int gmax=Integer.MIN_VALUE;
        int prefixprod=1;
        int suffixprod=1;
        
        // iterate on the nums
        for (int i=0; i <nums.length; i++) {
            int elem=nums[i];
            if (prefixprod==0)prefixprod=1;
            if (suffixprod==0)suffixprod=1;
            
            // update the prefix and suffix
            prefixprod = prefixprod * elem;
            suffixprod = suffixprod * nums[nums.length - i - 1];
            
            // update gmax
            gmax=Math.max(gmax, Math.max(prefixprod, suffixprod));
        }
        
        // return gmax
        return gmax;
    }
}
