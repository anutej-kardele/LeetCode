package LeetCode.Easy;

import LeetCode.TreeNode;

public class PN104 {

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return leftDepth < rightDepth ? rightDepth + 1 : leftDepth + 1;
    }
}
