package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class PN226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode initialNode = root;
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode thisNode = queue.poll();

            TreeNode temp = thisNode.left;
            thisNode.left = thisNode.right;
            thisNode.right = temp;

            if (thisNode.left != null)
                queue.offer(thisNode.left);

            if (thisNode.right != null)
                queue.offer(thisNode.right);
        }

        return initialNode;
    }
}
