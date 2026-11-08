package LeetCode;

public class TrieNode {
    public TrieNode[] children;
    public boolean isWord;
    public String word;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
        word = null;
    }
}
