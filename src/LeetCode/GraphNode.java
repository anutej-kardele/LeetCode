package LeetCode;

import java.util.List;
import java.util.ArrayList;

public class GraphNode extends Node {

    public List<GraphNode> neighbors;

    public GraphNode() {
        super(0);
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val) {
        super(_val);
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        super(_val);
        val = _val;
        neighbors = _neighbors;
    }

}
