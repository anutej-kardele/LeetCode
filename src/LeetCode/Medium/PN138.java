package LeetCode.Medium;

import java.util.HashMap;
import LeetCode.Node;

public class PN138 {

    public Node copyRandomList(Node head) {

        // HashMap where Key = Original Node, Value = Deep Copy Node
        HashMap<Node, Node> oldToNew = new HashMap<>();

        Node curr = head;

        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            Node cloneNode = oldToNew.get(curr);
            cloneNode.next = oldToNew.get(curr.next);
            cloneNode.random = oldToNew.get(curr.random);

            curr = curr.next;
        }

        return oldToNew.get(head);
    }
}
