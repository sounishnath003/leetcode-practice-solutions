class Solution {
public:
    
bool dfs(vector<vector<char>> &board, int row, int col, string &word, int wc)
{
    if(wc == (int) word.length()){
        return true;
    }
    if(row < 0 or row >= board.size() or col < 0 or col >= board[row].size() or board[row][col] != word[wc])
    {
        return false;
    }
    {
        char temp = board[row][col];
        board[row][col] = ' ';
        bool found = (dfs(board, row+1, col, word, wc+1) || dfs(board, row-1, col, word, wc+1)
                      || dfs(board, row, col+1, word, wc+1) || dfs(board, row, col-1, word, wc+1));
        board[row][col] = temp;
        return found;
    }
}
​
    
    bool exist(vector<vector<char>>& board, string word) {
        
        int M = board.size(), N = board[0].size();
        if(board.empty()){
            return false;
        }
        for(int row = 0; row < M; row++){
            for(int col = 0; col < N; col++){
                if(board[row][col] == word[0] && dfs(board, row, col, word, 0)){
                    return true;
