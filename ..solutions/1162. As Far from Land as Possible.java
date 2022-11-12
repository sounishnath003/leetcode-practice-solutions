class Solution {
​
    class Point {
        int x;
        int y;
        int level;
​
        Point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
​
    public int maxDistance(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
​
        Queue<Point> queue = new LinkedList<Point>();
​
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                // if land
                if (grid[row][col] == 1) {
                    queue.offer(new Point(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }
​
        int[] dx = new int[] { 1, -1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };
​
        int maxLevel = -1;
​
        // process each land
        while (queue.isEmpty() == false) {
            Point land = queue.remove();
​
            maxLevel = Math.max(land.level, maxLevel);
​
            for (int k = 0; k < 4; k++) {
                int nrow = land.x + dx[k];
                int ncol = land.y + dy[k];
​
                if (nrow >= 0 && nrow < R && ncol >= 0 && ncol < C && visited[nrow][ncol] == false) {
                    visited[nrow][ncol] = true;
                    queue.add(new Point(nrow, ncol, land.level + 1));
                }
            }
        }
​
        return maxLevel > 0 ? maxLevel : -1; // why 0 becase if no land / water no solution can be found!
    }
}
