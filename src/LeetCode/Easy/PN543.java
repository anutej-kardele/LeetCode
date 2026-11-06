package LeetCode.Easy;

import LeetCode.TreeNode;

public class PN543 {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxDiameter;
    }

    public int diameter(TreeNode root) {
        if (root == null)
            return 0;

        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);

        maxDiameter = Math.max(maxDiameter, leftDia + rightDia);

        return Math.max(leftDia, rightDia) + 1;
    }
}
