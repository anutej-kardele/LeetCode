package LeetCode.Medium;

public class PN130 {

    public static void main(String[] args) {

        char[][] board = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };

        System.out.println("Existing board:");
        for (char[] row : board) {
            System.out.println(new String(row));
        }

        new PN130().solve(board);

        System.out.println("Solved board:");
        for (char[] row : board) {
            System.out.println(new String(row));
        }
    }

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    if (board[i][j] == 'O')
                        dfs(board, i, j);
                }
            }
        }

        // Stack now contains all 'O's located on the perimeter of the board

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'S')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }

    public void dfs(char[][] board, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'S')
            return;

        board[i][j] = 'S';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

}
