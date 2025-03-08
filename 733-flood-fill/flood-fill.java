class Solution {
    // https://leetcode.com/problems/flood-fill/
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int startColor = image[sr][sc];

        if (startColor == color) {
            return image;
        }

        boolean[][] visited = new boolean[rows][cols];
        colorGraph(image, sr, sc, rows, cols, startColor, color, visited);
        return image;
    }

    private void colorGraph(int[][] image, int row, int col, int rows, int cols, int startColor, int color,
            boolean[][] visited) {
        visited[row][col] = true;
        image[row][col] = color;

        int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol]) {
                continue;
            }

            if (image[newRow][newCol] == startColor) {
                colorGraph(image, newRow, newCol, rows, cols, startColor, color, visited);
            }
        }
    }


}