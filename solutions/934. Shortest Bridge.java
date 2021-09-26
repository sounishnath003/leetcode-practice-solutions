class Solution {
    int row, col;
    public int shortestBridge(int[][] a) {
        row = a.length;
        col = a[0].length;
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < row && q.isEmpty(); i++) {
            for (int j = 0; j < col && q.isEmpty(); j++) {
                if (a[i][j]==1) dfs(i, j, q, a);
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (q.isEmpty()==false) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int i = cur[0] + dir[0], j = cur[1] + dir[1];
                if (i < 0 || i == row || j < 0 || j == col || a[i][j]==-1) continue;
                if (a[i][j]==1) return cur[2];
                a[i][j] = -1;
                q.add(new int[]{i, j, cur[2]+1});//increase distance
            }
        }
        return -1;
    }
    public void dfs(int i, int j, Queue<int[]> q, int[][] a) {
        if (i < 0 || i == row || j < 0 || j == col || a[i][j]!=1) return;
        //a value is 1
        a[i][j] = -1;
        q.add(new int[]{i, j, 0});//0 distance travelled
        dfs(i+1, j, q, a);
        dfs(i-1, j, q, a);
        dfs(i, j+1, q, a);
        dfs(i, j-1, q, a);
    }
}
