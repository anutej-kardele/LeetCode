package LeetCode.Medium;

import LeetCode.Node;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PN146 {

    public static void main(String[] args) {

        // String[] operations = { "LRUCache", "put", "put", "get", "put", "get", "put",
        // "get", "get", "get" };
        // int[][] values = { { 2 }, { 1, 1 }, { 2, 2 }, { 1 }, { 3, 3 }, { 2 }, { 4, 4
        // }, { 1 }, { 3 }, { 4 } };
        String[] expected = { null, null, null, "1", null, "-1", null, "-1", "3", "4" };
        List<String> actual = new ArrayList<>();

        LRUCache lruCache = new LRUCache(2);
        actual.add(null);
        lruCache.put(1, 1);
        actual.add(null);
        lruCache.put(2, 2);
        actual.add(null);
        actual.add(String.valueOf(lruCache.get(1)));
        lruCache.put(3, 3);
        actual.add(null);
        actual.add(String.valueOf(lruCache.get(2)));
        lruCache.put(4, 4);
        actual.add(null);
        actual.add(String.valueOf(lruCache.get(1)));
        actual.add(String.valueOf(lruCache.get(3)));
        actual.add(String.valueOf(lruCache.get(4)));

        System.out.println("Actual: " + actual);
        System.out.println("Expected: " + Arrays.toString(expected));

    }

}

class LRUCache {

    Node head;
    Node tail;
    int capacity;
    int size;

    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;

        // two pointers for the doubly linked list
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        Node node = map.get(key);

        if (node == null)
            return -1;

        // restructure key position
        remove(node);
        add(node);

        return node.val;
    }

    public void put(int key, int value) {

        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
        } else if (size == capacity) {
            map.remove(head.next.key);
            size--;
            remove(head.next);
        }

        if (node == null) {
            node = new Node(value, key);
            map.put(key, node);
            size++;
        }
        add(node);
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void add(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }

}