class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
​
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0}); // [row, col, obstacle, level]
        int[][] visited = new int[grid.length][grid[0].length];
        for (int[] v : visited) Arrays.fill(v, Integer.MAX_VALUE);
        visited[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            if (entry[0] == grid.length - 1 && entry[1] == grid[0].length - 1) return entry[3];
            for (int[] dir : DIRS) {
                int row = entry[0] + dir[0], col = entry[1] + dir[1];
                boolean inbound = row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
                if (inbound) {
                    int obstacle = entry[2] + grid[row][col];
                    if (obstacle <= k && obstacle < visited[row][col]) {
                        visited[row][col] = obstacle;
                        queue.offer(new int[]{row, col, obstacle, entry[3] + 1});
                    }
                }
            }
        }
        return -1;
    }
}
