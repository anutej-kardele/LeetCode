package LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;

import LeetCode.TrieNode;

public class PN212 {

    private TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words)
            insert(word);

        int rows = board.length;
        int cols = board[0].length;
        List<String> result = new ArrayList<>();
        boolean[][] occupied = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                search(board, r, c, root, occupied, result);
            }
        }
        return result;
    }

    private void search(char[][] board, int r, int c, TrieNode node, boolean[][] occupied, List<String> result) {

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || occupied[r][c])
            return; // Out of bounds or already visited

        int index = board[r][c] - 'a';
        if (node.children[index] == null)
            return; // The current board character is not in our Trie path

        TrieNode nextNode = node.children[index];

        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // De-duplicate: clear it so we never add it again
        }

        occupied[r][c] = true;

        // Run the search in all 4 directions (Clean and simple!)
        search(board, r + 1, c, nextNode, occupied, result); // down
        search(board, r - 1, c, nextNode, occupied, result); // up
        search(board, r, c + 1, nextNode, occupied, result); // right
        search(board, r, c - 1, nextNode, occupied, result); // left

        occupied[r][c] = false;
    }

    public void insert(String word) {

        // look into root node first
        TrieNode curr = root;
        char[] charecters = word.toCharArray();

        for (char ch : charecters) {

            // get word
            int index = ch - 'a';
            if (curr.children[index] == null) { // create new if null
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.word = word;
    }

}
