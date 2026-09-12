package LeetCode.Hard;

import java.util.LinkedList;
import java.util.Queue;
import LeetCode.TreeNode;

public class PN297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null)
            return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                sb.append("n,");
                continue;
            }

            sb.append(current.val).append(",");

            queue.offer(current.left);
            queue.offer(current.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.isEmpty())
            return null;

        String[] values = data.split(",");
        int i = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(values[i]);
        i++;
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode val = queue.poll();

            String left = values[i];
            i++;
            String right = values[i];
            i++;

            if (!left.equals("n")) {
                TreeNode leftTree = new TreeNode(Integer.parseInt(left));
                val.left = leftTree;
                queue.offer(leftTree);
            }

            if (!right.equals("n")) {
                TreeNode rightTree = new TreeNode(Integer.parseInt(right));
                val.right = rightTree;
                queue.offer(rightTree);
            }

        }

        return root;
    }
}
