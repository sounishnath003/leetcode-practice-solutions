class Solution {
    private final char IDENTIFIER_CHARACTER = '#';
​
    public void solve(char[][] board) {
        if (board == null)
            return;
​
        int R = board.length;
        int C = board[0].length;
​
        if (R <= 2 || C <= 2)
            return;
​
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                char value = board[row][col];
​
                if (value == 'O' && isBoundaryCell(row, col, R, C)) {
                    traverseAndChange(board, row, col, R, C);
                }
            }
        }
​
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                char value = board[row][col];
​
                if (value == 'O') {
                    board[row][col] = 'X';
                } else if (value == IDENTIFIER_CHARACTER) {
                    board[row][col] = 'O';
                }
            }
        }
    }
​
    private void traverseAndChange(char[][] board, int row, int col, int R, int C) {
        board[row][col] = IDENTIFIER_CHARACTER;
​
        int[] dr = new int[] { -1, 1, 0, 0 };
        int[] dc = new int[] { 0, 0, 1, -1 };
​
        for (int k = 0; k < 4; k++) {
            int nrow = row + dr[k];
            int ncol = col + dc[k];
​
            if (nrow < 0 || nrow >= R || ncol < 0 || ncol >= C)
                continue;
​
            char value = board[nrow][ncol];
            if (value == 'O') {
                traverseAndChange(board, nrow, ncol, R, C);
            }
        }
    }
​
    private boolean isBoundaryCell(int row, int col, int r, int c) {
        return row == 0 || row == r - 1 || col == 0 || col == c - 1;
    }
}
