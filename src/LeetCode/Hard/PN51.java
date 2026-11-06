package LeetCode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PN51 {

    List<List<String>> solution = new ArrayList<>();

    boolean[] cols;
    boolean[] diag1; // Major diagonals (\)
    boolean[] diag2; // Minor diagonals (/)

    // Better solution with O(1) isValid lookup by just checking if this column or
    // diagonal1 or diagonal2 is already occupied

    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start backtracking directly from row 0
        backtrack(board, 0, n);

        return solution;
    }

    public void backtrack(char[][] board, int row, int n) {

        if (row >= n) {
            solution.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2])
                continue;

            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(board, row + 1, n);

            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    // Old Solution with O(N) previosu isValid lookup

    public List<List<String>> solveNQueensSlow(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        for (int col = 0; col < n; col++) {
            board[0][col] = 'Q';
            backtrackOLD(board, 1, n);
            board[0][col] = '.';
        }

        return solution;
    }

    public void backtrackOLD(char[][] board, int row, int n) {

        if (row >= n) {
            solution.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (!isValid(board, row, col))
                continue;

            board[row][col] = 'Q';

            backtrackOLD(board, row + 1, n);

            board[row][col] = '.';
        }
    }

    public List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public boolean isValid(char[][] board, int row, int col) {

        // 1. Check straight UP the column
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 'Q')
                return false;
        }

        // 2. Check UP-LEFT diagonal
        // We start at the target cell and step up-and-left until we hit a wall
        int rLeft = row;
        int cLeft = col;
        while (rLeft >= 0 && cLeft >= 0) {
            if (board[rLeft][cLeft] == 'Q')
                return false;
            rLeft--; // Move up
            cLeft--; // Move left
        }

        // 3. Check UP-RIGHT diagonal
        // We start at the target cell and step up-and-right until we hit a wall
        int rRight = row;
        int cRight = col;
        while (rRight >= 0 && cRight < board.length) {
            if (board[rRight][cRight] == 'Q')
                return false;
            rRight--; // Move up
            cRight++; // Move right
        }

        // If it survives all three directional checks, the spot is perfectly safe!
        return true;
    }
}
