package LeetCode.Hard;

import LeetCode.TreeNode;

public class PN124 {

    public static void main(String[] args) {
        System.out.println("PN124");
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxPathSumRec(root);
        return max;
    }

    public int maxPathSumRec(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = Math.max(0, maxPathSumRec(root.left));
        int rightSum = Math.max(0, maxPathSumRec(root.right));

        int total = root.val + leftSum + rightSum;
        max = Math.max(max, total);

        return root.val + Math.max(leftSum, rightSum);
    }
}
