package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

import LeetCode.GraphNode;

public class PN133 {

    public static void main(String[] args) {

    }

    // public Node cloneGraph(Node node) {
    public GraphNode cloneGraph(GraphNode node) {

        if (node == null)
            return null;

        if (node.neighbors.isEmpty())
            return new GraphNode(node.val);

        GraphNode build = new GraphNode(node.val);

        Map<Integer, GraphNode> map = new HashMap<>();
        map.put(node.val, build);

        dfs(node, build, map);

        return build;
    }

    public void dfs(GraphNode node, GraphNode build, Map<Integer, GraphNode> map) {

        for (GraphNode gn : node.neighbors) {

            if (!map.containsKey(gn.val)) {
                GraphNode newNode = new GraphNode(gn.val);
                map.put(gn.val, newNode);
                dfs(gn, newNode, map);
            }

            build.neighbors.add(map.get(gn.val));
        }
    }

}
