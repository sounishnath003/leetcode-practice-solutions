class Solution {
    public int orangesRotting(int[][] grid) {
        int timeElapsed = 0;
​
        int R = grid.length;
        int C = grid[0].length;
​
        // faster access for fresh / rotten
        Set<String> freshOranges = new HashSet<String>();
        Set<String> rottenOranges = new HashSet<String>();
​
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                int o = grid[row][col];
                String key = generateKey(row, col);
                if (o == 1)
                    freshOranges.add(key);
                else if (o == 2)
                    rottenOranges.add(key);
            }
        }
​
        int[] dx = new int[] { 1, -1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };
​
        // joto khon fresh orange ache
        while (freshOranges.isEmpty() == false) {
            Set<String> infected = new HashSet<String>();
​
            for (String s : rottenOranges) {
                int row = s.charAt(0) - '0';
                int col = s.charAt(2) - '0';
​
                for (int k = 0; k < 4; k++) {
                    int nrow = row + dx[k];
                    int ncol = col + dy[k];
                    String key = generateKey(nrow, ncol);
                    if (freshOranges.contains(key) == true) {
                        freshOranges.remove(key);
                        infected.add(key);
                    }
                }
            }
            if (infected.size() == 0)
                return -1;
            rottenOranges.addAll(infected);
            timeElapsed++;
        }
​
        return timeElapsed;
    }
​
    private String generateKey(int row, int col) {
        // TODO Auto-generated method stub
        return "" + row + "#" + col;
    }
​
}
