class Solution {
    public int trap(int[] height) {
        return optimized(height);
    }
​
    private int optimized(int[] height) {
        int n = height.length;
        int leftwall=0;
        int rightwall=0;
        int left=0;
        int right=n-1;
        int water=0;
        while (left <= right){
           if (height[left] <= height[right]) {
               if (leftwall < height[left]) {
                   leftwall = height[left];
               } else {
                   water += leftwall-height[left];
               }
               left++;
           } else {
               if (rightwall <= height[right]) {
                   rightwall=height[right];
               } else {
                   water += rightwall-height[right];
               }
               right--;
           }
        }
        return water;
    }
​
    private int bruteforce(int[] height) {
        // TC: O(N); SC: O(N)
        int n = height.length;
        int[] leftwalls = new int[n];
        leftwalls[0]=height[0];
        for (int i=1;i<n;i++) leftwalls[i] = Math.max(height[i], leftwalls[i-1]);
        int[] rightwalls = new int[n];
        rightwalls[n-1]=height[n-1];
        for (int i=n-2;i>=0;i--) rightwalls[i] = Math.max(height[i], rightwalls[i+1]);
        int water=0;
        for (int i=0; i<n; i++)
            water += Math.min(leftwalls[i], rightwalls[i]) - height[i];
        return water;
    }
}
