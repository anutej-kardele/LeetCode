package LeetCode.Medium;

import LeetCode.TreeNode;

public class PN1448 {

    public int goodNodes(TreeNode root) {
        return calculate(root, root.val);
    }

    // Saved O(1)*3 space complexity
    /*
     * FALSE ASSUMPTION: Inlining the return statement saves O(1) space per
     * recursive call.
     * 
     * TRUTH: The space complexity remains O(h) due to the call stack. Even without
     * explicit integer variables, the JVM still uses "hidden temporary storage"
     * (on the stack or in CPU registers) to hold the evaluated result of
     * calculate(root.left) while it waits for the entire calculate(root.right)
     * branch to finish before it can add them together. Modern JIT compilers
     * optimize explicit local variables anyway, so prioritize readability.
     */
    public int calculate(TreeNode root, int maxValue) {

        if (root == null)
            return 0;

        if (root.val >= maxValue)
            maxValue = root.val;

        return calculate(root.left, maxValue) + calculate(root.right, maxValue) + (root.val == maxValue ? 1 : 0);
    }

    public int calculateBetter(TreeNode root, int maxValue) {

        if (root == null)
            return 0;

        int node = 0;
        if (root.val >= maxValue) {
            maxValue = root.val;
            node = 1;
        }

        node += calculate(root.left, maxValue);
        node += calculate(root.right, maxValue);

        return node;
    }

    public int calculateOLD(TreeNode root, int maxValue) {

        if (root == null)
            return 0;

        int node = 0;
        if (root.val >= maxValue) {
            maxValue = root.val;
            node = 1;
        }

        int leftNode = calculate(root.left, maxValue);
        int rightNode = calculate(root.right, maxValue);

        return leftNode + rightNode + node;
    }
}
