class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int R = img1.length;
        int C = img1.length;
​
        int maxoverlaps = 0;
        for (int row = -R; row < R; row++) {
            for (int col = -C; col < C; col++) {
                int currentOverlap = solver(img1, img2, row, col, R, C);
                maxoverlaps = Math.max(maxoverlaps, currentOverlap);
            }
        }
​
        return maxoverlaps;
    }
​
    private int solver(int[][] img1, int[][] img2, int crow, int ccol, int R, int C) {
        int count = 0;
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                int nrw = row + crow;
                int ncl = col + ccol;
                if (isSafeArea(nrw, ncl, R, C) && hasPixel(img1[row][col], img2[nrw][ncl])) {
                    count++;
                }
            }
        }
​
        return count;
    }
​
    private boolean hasPixel(int p1, int p2) {
        return (p1 == 1) && (p1 == p2);
    }
​
    private boolean isSafeArea(int nrw, int ncl, int r, int c) {
        return nrw >= 0 && nrw < r && ncl >= 0 && ncl < c;
    }
}
