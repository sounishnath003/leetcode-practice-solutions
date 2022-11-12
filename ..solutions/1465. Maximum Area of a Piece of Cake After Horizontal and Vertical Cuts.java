class Solution {
    private final int mod = (int) 1e9 + 7;
​
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
​
        final int hcn = horizontalCuts.length;
        final int vcn = verticalCuts.length;
​
        int maxheight = Math.max(horizontalCuts[0], h - horizontalCuts[hcn - 1]);
        int maxvertical = Math.max(verticalCuts[0], w - verticalCuts[vcn - 1]);
​
        for (int i = 1; i < hcn; i++) {
            maxheight = Math.max(maxheight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
​
        for (int i = 1; i < vcn; i++) {
            maxvertical = Math.max(maxvertical, verticalCuts[i] - verticalCuts[i - 1]);
        }
​
        int possibleMaxArea = (int) (1L * maxheight * maxvertical) % mod;
        return possibleMaxArea;
    }
}
​
