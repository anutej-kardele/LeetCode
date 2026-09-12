package LeetCode.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import LeetCode.TreeNode;

public class PN102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();
        if (root == null)
            return output;

        List<Integer> thisVal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            thisVal = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode value = queue.poll();
                thisVal.add(value.val);

                if (value.left != null)
                    queue.offer(value.left);
                if (value.right != null)
                    queue.offer(value.right);
            }

            output.add(thisVal);
        }

        return output;
    }
}
