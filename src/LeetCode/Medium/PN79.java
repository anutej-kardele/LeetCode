package LeetCode.Medium;

public class PN79 {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (existWord(board, wordArray, 0, i, j))
                        return true;
                }
            }
        }

        return false;
    }

    public boolean existWord(char[][] board, char[] wordArray, int index, int row, int col) {

        if (index >= wordArray.length)
            return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != wordArray[index])
            return false;

        char temp = board[row][col];
        board[row][col] = '*';

        boolean found = existWord(board, wordArray, index + 1, row + 1, col) ||
                existWord(board, wordArray, index + 1, row - 1, col) ||
                existWord(board, wordArray, index + 1, row, col + 1) ||
                existWord(board, wordArray, index + 1, row, col - 1);

        board[row][col] = temp;

        return found;
    }
}
