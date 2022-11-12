class Solution {
public:
    
void f(vector<vector<char>> &board, int row, int col) {
    if(row < 0 || col < 0 || row >= board.size() || col >= board[row].size() || board[row][col] != 'X' ) {
        return ;
    }
    
    board[row][col] = '.';
    f(board, row+1, col);
    f(board, row-1, col);
    f(board, row, col+1);
    f(board, row, col-1);
    
    return ;
}
    
    int countBattleships(vector<vector<char>>& board) {
        int ans = 0;
        for(int row = 0; row < (int) board.size(); row++) {
            for(int col = 0; col < (int) board[row].size(); col++) {
                if(board[row][col] == 'X') {
                    ans++;
                    f(board, row, col);
                }
            }
        }
        return ans;
    }
};
