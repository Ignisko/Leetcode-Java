/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board? */

public class Solution {
    private char[][] board;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        if (rows == 0) return false;
        this.cols = board[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, String word, int index) {
        // Word found
        if (index == word.length()) return true;
        
        // Out of bounds or not matching
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != word.charAt(index)) return false;
        
        // Temporarily mark the cell as visited
        board[r][c] ^= 256; // A way to mark the cell as visited in a reversible manner
        boolean exists = dfs(r + 1, c, word, index + 1) ||
                         dfs(r - 1, c, word, index + 1) ||
                         dfs(r, c + 1, word, index + 1) ||
                         dfs(r, c - 1, word, index + 1);
        // Backtrack and unmark the cell
        board[r][c] ^= 256; // Revert the cell to its original state
        
        return exists;
    }
}

