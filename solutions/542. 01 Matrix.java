class Solution {
​
    private class Pair {
        int x;
        int y;
​
        Pair(int x , int y) {
            this.x = x;
            this.y = y;
        }
    }
​
    private int[] dx = new int[]{1,-1,0,0};
    private int[] dy = new int[]{0,0,-1,1};
​
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
​
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        Queue<Pair> queue = new LinkedList<>();
​
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair(i,j));
                    dist[i][j] = 0;
                }
            }
        }
​
​
        while(queue.isEmpty() == false) {
            Pair p = queue.remove();
​
            for (int k = 0; k < 4; k++) {
                int nx = p.x + this.dx[k];
                int ny = p.y + this.dy[k];
​
                if ( 0 <= nx && nx < n && 0 <= ny && ny < m && dist[nx][ny] == Integer.MAX_VALUE) {
                    dist[nx][ny] = 1 + dist[p.x][p.y];
                    queue.add( new Pair(nx, ny) );
                }
​
            }
        }
​
        return dist;
    }
}
