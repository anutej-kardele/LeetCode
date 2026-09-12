package LeetCode.Medium;

import LeetCode.TreeNode;

public class PN230 {

    private int count = 0;
    private int value = 0;

    public int kthSmallest(TreeNode root, int k) {

        count = k;
        traverse(root);
        return value;
    }

    private void traverse(TreeNode node) {

        if (node == null)
            return;

        traverse(node.left);

        count--;
        if (count == 0) {
            value = node.val;
            return;
        }

        traverse(node.right);
    }
}
