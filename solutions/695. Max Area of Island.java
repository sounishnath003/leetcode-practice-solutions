class Solution {
    private class Pair {
        int x;
        int y;
​
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
​
    private int[] dx = new int[] { 1, -1, 0, 0 };
    private int[] dy = new int[] { 0, 0, 1, -1 };
    private int maxarea = 0;
​
    public void area(int[][] grid, Pair start, boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        if(visited[start.x][start.y] == true) return;
        queue.add(start);
        int curarea = 1;
        while (queue.isEmpty() == false) {
            Pair p = queue.remove();
            visited[p.x][p.y] = true;
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
​
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (grid[nx][ny] == 1 && visited[nx][ny] == false) {
                        curarea++;
                        visited[nx][ny] = true;
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
            
        }
        // System.out.println( start.x + " " + start.y + " " + curarea);
        this.maxarea = Math.max(curarea, this.maxarea);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
​
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    Pair start = new Pair(i, j);
                    area(grid, start, visited);
                }
            }
        }
​
        
​
        return this.maxarea;
    }
}
