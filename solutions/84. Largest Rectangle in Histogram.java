class Solution {
    public int largestRectangleArea(int[] heights) {
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
        }
​
        return maxarea;
    }
​
    private int[] getRightHeightIndices(int[] heights) {
        // TODO Auto-generated method stub
        final int n = heights.length;
        int[] walls = new int[n];
​
        Stack<Integer> stack = new Stack<>();
​
        for (int i = n - 1; i >= 0; i--) {
            int curHeight = heights[i];
​
            while (stack.isEmpty() == false && heights[stack.peek()] >= curHeight)
                stack.pop();
​
            if (stack.isEmpty() == true)
                walls[i] = n;
            else
                walls[i] = stack.peek();
​
            stack.push(i);
        }
​
        return walls;
    }
​
    private int[] getLeftHeightIndcies(int[] heights) {
        // TODO Auto-generated method stub
​
        final int n = heights.length;
        int[] walls = new int[n];
​
        Stack<Integer> stack = new Stack<>();
​
        for (int i = 0; i < n; i++) {
            int curheight = heights[i];
​
            while (stack.isEmpty() == false && heights[stack.peek()] >= curheight)
                stack.pop();
​
            if (stack.isEmpty() == true)
                walls[i] = -1;
            else
                walls[i] = stack.peek();
​
            stack.push(i);
        }
​
        return walls;
    }
}
​
