package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;

import LeetCode.TreeNode;

public class PN226 {

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
