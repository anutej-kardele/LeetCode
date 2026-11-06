package LeetCode.Easy;

import LeetCode.TreeNode;

public class PN110 {

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode root) {
        if (root == null)
            return 0;

        int leftH = depth(root.left);
        if (leftH == -1)
            return -1;
        int rightH = depth(root.right);
        if (rightH == -1)
            return -1;

        if (Math.abs(leftH - rightH) > 1)
            return -1;

        return Math.max(leftH, rightH) + 1;
    }
}
