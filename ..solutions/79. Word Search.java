class Solution {
​
    private class Pair {
        int row;
        int col;
​
        Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
​
    private int[] dx = new int[] { 1, -1, 0, 0 };
    private int[] dy = new int[] { 0, 0, -1, 1 };
​
    public boolean exist(char[][] board, String word) {
        final int R = board.length;
        final int C = board[0].length;
​
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (search(board, word, 0, new Pair(row, col)) == true) {
                    return true;
                }
            }
        }
​
        return false;
    }
​
    private boolean search(char[][] board, String word, int wordCount, Pair node) {
​
        if (wordCount == word.length()) {
            return true;
        }
​
        if (isNotUnderSafeArea(board, node.row, node.col, word, wordCount) == true)
            return false;
​
        // faith
        if (word.charAt(wordCount) == board[node.row][node.col]) {
            char orignalCharacter = board[node.row][node.col];
            board[node.row][node.col] = '#';
            for (int k = 0; k < 4; k++) {
                boolean rres = search(board, word, wordCount + 1, new Pair(node.row + dx[k], node.col + dy[k]));
                if (rres == true) {
                    return true;
                }
            }
            board[node.row][node.col] = orignalCharacter;
        }
​
        return false;
    }
​
    private boolean isNotUnderSafeArea(char[][] board, int row, int col, String word, int wordCount) {
​
        return row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || word.charAt(wordCount) != board[row][col] || board[row][col] == '#';
​
    }
}
