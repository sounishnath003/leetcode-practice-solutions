class Solution {
public int maxProduct(int[] nums) {
    return brainiestapproach(nums);
}
​
private int brainiestapproach(int[] nums) {
    // TODO Auto-generated method stub
            int leftprod = 1;
            int rightprod = 1;
            
            int result=nums[0];
            
            for(int i = 0; i < nums.length; i++) {
                int elem1 = nums[i];
                int elem2 = nums[nums.length-1-i];
                
                leftprod = leftprod == 0 ? 1 : leftprod;
                rightprod = rightprod == 0 ? 1 : rightprod;
                
                leftprod = leftprod * elem1;
                rightprod = rightprod * elem2;
                
                result=Math.max(result, Math.max(leftprod, rightprod));
            }
            
            return result;
}
​
private int goodapproch(int[] nums) {
    int n = nums.length;
    int maxprod = nums[0];
    int minprod = nums[0];
    int result = nums[0];
​
    for (int i = 1; i < n; i++) {
        int e = nums[i];
        if (e <= 0) {
            // swap
            int t = maxprod;
            maxprod = minprod;
            minprod = t;
        }
        maxprod = Math.max(nums[i], maxprod * e);
        minprod = Math.min(nums[i], minprod * e);
        result = Math.max(result, maxprod);
    }
​
    return result;
}
}
