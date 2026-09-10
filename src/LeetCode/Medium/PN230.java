package LeetCode.Medium;

public class PN230 {

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
