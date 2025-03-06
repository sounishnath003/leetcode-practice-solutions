class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        // store the left
        for (int i = 0; i < n; i++) {
            if (i == 0 || left[i - 1] < height[i])
                left[i] = height[i];
            else {
                left[i] = left[i - 1];
            }
        }
        // store the right
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || right[i + 1] < height[i])
                right[i] = height[i];
            else {
                right[i] = right[i + 1];
            }
        }
        System.out.println("left=" + Arrays.toString(left));
        System.out.println("right=" + Arrays.toString(right));

        int water = 0;
        for (int i = 0; i < n; i++) {
            int h = height[i];
            water += Math.min(left[i], right[i]) - h;
        }
        return water;

    }
}