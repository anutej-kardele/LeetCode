package LeetCode.Easy;

import LeetCode.TreeNode;

public class PN572 {

    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null)
            return false;

        if (isSameTree(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
