package LeetCode;

public class Node {
    public int val;
    public int key;
    public Node next;
    public Node prev;
    public Node random;

    public Node(int key) {
        this.key = key;
        this.next = null;
        this.random = null;
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int key, int val, Node next, Node prev) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
