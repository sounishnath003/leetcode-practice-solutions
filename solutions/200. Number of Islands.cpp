class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        
        if(grid.empty()) {
            return 0;
        }
        
        int H = grid.size(),
            W = grid[0].size();
        
        int ans = 0;
        for(int row = 0; row < H; row++) {
            for(int col = 0; col < W; col++) {
                if(grid[row][col] == '1') {
                    ans += dfs(grid, row, col, H, W);
                }
            }
        }
        return ans;
    }
    
    int dfs(vector<vector<char>>& grid, int row, int col, int H, int W) {
        
        if(row < 0 or row >= H || col < 0 or col >= W || grid[row][col] != '1' ) {
            return 0;
        }
        
        grid[row][col] = '0';
        
        dfs(grid, row+1, col, H, W);
        dfs(grid, row-1, col, H, W);
        dfs(grid, row, col+1, H, W);
        dfs(grid, row, col-1, H, W);
        
        return 1;
    }
};
