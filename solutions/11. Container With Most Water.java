class Solution {
    public int maxArea(int[] height) {
        return mostWater(height);
    }
    public int mostWater(int[] heights) {
        // write your code here
        int maxwater = 0;
​
        int i = 0;
        int j = heights.length-1;
​
        while (i < j) {
            int l = j - i;
            int h = Math.min( heights[i], heights[j] );
            int water = l * h;
​
            maxwater = Math.max(maxwater, water);
​
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
​
        return maxwater;
    }
​
}
