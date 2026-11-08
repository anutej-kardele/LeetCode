package LeetCode.Medium;

import LeetCode.TrieNode;

public class PN208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Inserted: apple");
        System.out.println("Search: apple: " + trie.search("apple")); // returns true
        System.out.println("Search: app: " + trie.search("app")); // returns false
        System.out.println("Starts with: app: " + trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println("Inserted: app");
        System.out.println("Search: app: " + trie.search("app")); // returns true
    }

}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
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
        curr.isWord = true;
    }

    public boolean search(String word) {

        TrieNode curr = root;
        char[] charecters = word.toCharArray();

        for (char ch : charecters) {

            int index = ch - 'a';
            if (curr.children[index] == null) { // create new if null
                return false;
            }
            curr = curr.children[index];
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;
        char[] charecters = prefix.toCharArray();

        for (char ch : charecters) {

            int index = ch - 'a';
            if (curr.children[index] == null) { // create new if null
                return false;
            }
            curr = curr.children[index];
        }

        return true;
    }
}
