package LeetCode.Easy;

import LeetCode.TreeNode;

public class PN100 {

    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;

        boolean left_tree = isSameTree(p.left, q.left);
        boolean right_tree = isSameTree(p.right, q.right);

        return !left_tree || !right_tree ? false : true;
    }

}
