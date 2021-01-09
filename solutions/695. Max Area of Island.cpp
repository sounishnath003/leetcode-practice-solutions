class Solution {
    int H,W;
    vector<vector<int>> grid;
    int dfs(int row, int col) {
        if((row < 0 || row >= H )|| (col < 0 || col >= W) || grid[row][col]==0) {
            return 0;
        }
        grid[row][col]=0;
​
        int count = 1;
        count += dfs(row+1,col) + dfs(row-1,col) + dfs(row,col+1) + dfs(row,col-1);
        return count;
    };
​
public:
    int maxAreaOfIsland(vector<vector<int>>& matrix) {
        grid = matrix;
        H = matrix.size(), W = matrix[0].size();
        int maxarea = 0;
        for (int row = 0; row < H; row++) {
            for (int col = 0; col < W; col++) {
                if (grid[row][col]) {
                    maxarea = max(maxarea, dfs(row, col));
                }
            }
        }
        return maxarea;
    }
};
