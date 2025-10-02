package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;
// import javax.swing.tree.TreeNode;

public class PN100 {

    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            if (p == null && q == null)
                return true;
            else
                return false;
        }

        Queue<TreeNode> queue_P = new LinkedList<>();
        Queue<TreeNode> queue_Q = new LinkedList<>();

        queue_P.add(p);
        queue_Q.add(q);

        // check nodes
        if (queue_P.peek().val != queue_Q.peek().val)
            return false;

        while (queue_P.peek() != null && queue_Q.peek() != null) {

            // check left
            TreeNode node_P = queue_P.poll();
            TreeNode node_Q = queue_Q.poll();

            TreeNode node_P_L = node_P.left;
            TreeNode node_P_R = node_P.right;

            TreeNode node_Q_L = node_Q.left;
            TreeNode node_Q_R = node_Q.right;

            boolean check_L_Full = node_P_L != null && node_Q_L != null;
            boolean check_L_Empty = node_P_L == null && node_Q_L == null;

            boolean check_R_Full = node_P_R != null && node_Q_R != null;
            boolean check_R_Empty = node_P_R == null && node_Q_R == null;

            if (check_L_Full || check_L_Empty) {
                if (check_L_Full) {
                    if (node_P_L.val != node_Q_L.val)
                        return false;
                    else {
                        queue_P.add(node_P_L);
                        queue_Q.add(node_Q_L);
                    }
                }
            } else
                return false;

            if (check_R_Full || check_R_Empty) {
                if (check_R_Full) {
                    if (node_P_R.val != node_Q_R.val)
                        return false;
                    else {
                        queue_P.add(node_P_R);
                        queue_Q.add(node_Q_R);
                    }
                }
            } else
                return false;
        }

        return true;
    }

    // Definition for a binary tree node.
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

}
