package LeetCode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PN36 {

    public static void main(String[] args) {

        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        char[][] board2 = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board2));

    }

    public static boolean isValidSudoku(char[][] board) {

        int[] coluMap = new int[9];
        int[] rowMap = new int[9];
        int[] boxMap = new int[9];

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.')
                    continue;

                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);
                int mask = 1 << num;

                if ((rowMap[i] & mask) != 0 || (coluMap[j] & mask) != 0 || (boxMap[boxIndex] & mask) != 0)
                    return false;

                rowMap[i] |= mask;
                coluMap[j] |= mask;
                boxMap[boxIndex] |= mask;
            }
        }

        return true;
    }

    // has O(N^2) time complexity, but is a bit slow than ideal solution as the
    // Hashmap convert int to Integer
    public static boolean isValidSudokuOLD(char[][] board) {

        Map<Integer, Set<Integer>> coluMap = new HashMap<>();
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> boxMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {

            if (!rowMap.containsKey(i))
                rowMap.put(i, new HashSet<>());

            for (int j = 0; j < 9; j++) {

                if (!coluMap.containsKey(j))
                    coluMap.put(j, new HashSet<>());

                if (board[i][j] == '.')
                    continue;

                int num = board[i][j] - '0';
                int boxIndex = getBoxIndex(i, j);

                if (!boxMap.containsKey(boxIndex))
                    boxMap.put(boxIndex, new HashSet<>());

                boolean col = coluMap.get(j).contains(num);
                boolean row = rowMap.get(i).contains(num);
                boolean box = boxMap.get(boxIndex).contains(num);

                if (col || row || box)
                    return false;

                coluMap.get(j).add(num);
                rowMap.get(i).add(num);
                boxMap.get(boxIndex).add(num);
            }

        }

        return true;
    }

    public static int getBoxIndex(int i, int j) {

        return (i / 3) * 3 + (j / 3);
    }
}
