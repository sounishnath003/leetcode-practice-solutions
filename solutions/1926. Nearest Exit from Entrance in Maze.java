class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = maze.length;
        int n = maze[0].length;
      
        int count =0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]]=true;
        queue.offer(entrance);
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i =0; i<size;i++){
                int[] temp = queue.poll();
                
           
                for(int[] dir:directions){
                    int x = temp[0]+dir[0];
                    int y = temp[1]+dir[1];
                    if(x>=0&&x<m &&y>=0&&y<n&&visited[x][y]==false&&maze[x][y]=='.'){
                        queue.offer(new int[]{x,y});
                        if(x==0||y==0||x==m-1||y==n-1){
                            return count;
                        }
                        
                        visited[x][y]=true;
                   }
                }
            }            
        }
        return -1;             
        
    }
}
