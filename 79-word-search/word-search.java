class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Iterate through each cell in the board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Start the DFS search if the first character matches
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, word, 0, row, col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Directions: up, left, down, right
    private final int[][] directions = {
        {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        // Base case: all characters matched
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and current character match
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Temporarily mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all possible directions
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (dfs(board, word, index + 1, newRow, newCol)) {
                return true;
            }
        }

        // Restore the cell after backtracking
        board[row][col] = temp;

        return false;
    }
}
