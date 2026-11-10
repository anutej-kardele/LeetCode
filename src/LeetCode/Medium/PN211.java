package LeetCode.Medium;

import LeetCode.TrieNode;

public class PN211 {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        System.out.println("Inserted: bad");
        wordDictionary.addWord("dad");
        System.out.println("Inserted: dad");
        wordDictionary.addWord("mad");
        System.out.println("Inserted: mad");
        System.out.println("Search: pad: " + wordDictionary.search("pad")); // returns false
        System.out.println("Search: bad: " + wordDictionary.search("bad")); // returns true
        System.out.println("Search: .ad: " + wordDictionary.search(".ad")); // returns true
        System.out.println("Search: b..: " + wordDictionary.search("b..")); // returns true
    }

}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchDeep(word.toCharArray(), root, 0);
    }

    public boolean searchDeep(char[] word, TrieNode curr, int index) {

        if (index == word.length)
            return curr.isWord;

        char ch = word[index];

        boolean isFound = false;
        if (ch != '.') {
            int iDx = ch - 'a';
            if (curr.children[iDx] != null)
                return searchDeep(word, curr.children[iDx], index + 1);
        } else {
            // 26 search
            for (int i = 0; i < 26; i++)
                if (curr.children[i] != null && searchDeep(word, curr.children[i], index + 1))
                    return true;
        }

        return isFound;
    }
}