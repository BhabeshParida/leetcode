import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n];
        boolean[] antiDiag = new boolean[2 * n];
        
        backtrack(0, n, board, result, col, diag, antiDiag);
        
        return result;
    }
    
    private void backtrack(int row, int n, char[][] board,
                           List<List<String>> result,
                           boolean[] col, boolean[] diag, boolean[] antiDiag) {
        
        // base case: all queens placed
        if (row == n) {
            result.add(construct(board));
            return;
        }
        
        for (int j = 0; j < n; j++) {
            
            // check if safe
            if (col[j] || diag[row + j] || antiDiag[row - j + n - 1]) {
                continue;
            }
            
            // place queen
            board[row][j] = 'Q';
            col[j] = true;
            diag[row + j] = true;
            antiDiag[row - j + n - 1] = true;
            
            // move to next row
            backtrack(row + 1, n, board, result, col, diag, antiDiag);
            
            // backtrack (remove queen)
            board[row][j] = '.';
            col[j] = false;
            diag[row + j] = false;
            antiDiag[row - j + n - 1] = false;
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}