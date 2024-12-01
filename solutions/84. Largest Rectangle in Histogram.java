class Solution {
    // https://leetcode.com/problems/largest-rectangle-in-histogram/
    // :::IMPORTANT QUESTION:::
    public int largestRectangleArea(int[] heights) {
        // TC: O(N)
        // SC: O(N)
​
        int n = heights.length;
        int gmaxAns = 0;
​
        // stack
        Stack<Integer> stack = new Stack<>();
​
        for (int i = 0; i < n; i++) {
            // remove all the biggest elements from the stack than the current height[i]
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int element = heights[stack.pop()];
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
​
                int width = nse - pse - 1;
                int height = element;
​
                int area = width * height;
                gmaxAns = Math.max(gmaxAns, area);
            }
​
            stack.add(i); // add index not the value
        }
​
        // to process the left over elems
        while (!stack.isEmpty()) {
            int nse = n;
            int element = stack.isEmpty() ? -1 : heights[stack.pop()];
            int pse = stack.isEmpty() ? -1 : stack.peek();
            gmaxAns = Math.max(gmaxAns, element * (nse - pse - 1));
        }
​
        return gmaxAns;
    }
​
    public int largestRectangleArea2(int[] heights) {
        // TC: O(N + N)
        // SC: O(2N)
​
        int[] leftWalls = getLeftHeightIndcies(heights);
        int[] rightWalls = getRightHeightIndices(heights);
​
        int maxarea = 0;
​
        for (int i = 0; i < heights.length; i++) {
            int leftwall = leftWalls[i]; // left wall index
            int rightWall = rightWalls[i]; // right wall index
​
            int width = (rightWall - leftwall - 1);
            int height = heights[i];
​
            int area = width * height;
            maxarea = Math.max(maxarea, area);
