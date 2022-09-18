class Solution {
    public int trap(int[] height) {
        return this.easySolution(height);
    }
​
    private int easySolution(int[] height) {
        int n = height.length;
        int[] leftwalls = new int[n];
        leftwalls[0]=height[0];
        for (int i = 1; i < n; i++) leftwalls[i] = Math.max(height[i], leftwalls[i-1]);
​
        int[] rightWalls = new int[n];
        rightWalls[n-1]=height[n-1];
        for (int i=n-2; i>= 0; i--) rightWalls[i] = Math.max(height[i], rightWalls[i+1]);
​
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int storedWater = Math.min(leftwalls[i], rightWalls[i]) - height[i];
            totalWater += storedWater;
        }
​
        return totalWater;
    }
​
    private int optimized(int[] height) {
        int n = height.length;
        int leftwall = 0;
        int rightwall = 0;
        int left = 0;
        int right = n - 1;
        int water = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (leftwall < height[left]) {
                    leftwall = height[left];
                } else {
                    water += leftwall - height[left];
                }
                left++;
            } else {
                if (rightwall <= height[right]) {
                    rightwall = height[right];
                } else {
                    water += rightwall - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
