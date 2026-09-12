package LeetCode.Medium;

import LeetCode.TreeNode;

public class PN98 {

    public boolean isValidBST(TreeNode root) {

        return validate(root, null, null);
    }

    public static boolean validate(TreeNode root, Integer minValue, Integer maxValue) {

        if (root == null)
            return true;

        if (minValue != null && root.val <= minValue)
            return false;
        if (maxValue != null && root.val >= maxValue)
            return false;

        return validate(root.left, minValue, root.val) && validate(root.right, root.val, maxValue);
    }

}
