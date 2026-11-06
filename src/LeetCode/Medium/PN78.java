package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PN78 {

    List<List<Integer>> solution = new ArrayList<>();

    /*
     * MY Approach 1: STANDARD COMBINATORIAL BACKTRACKING (The Universal Template)
     * 
     * Time Complexity: O(N * 2^N)
     * - The for-loop combined with the 'index' variable ensures we mathematically
     * generate
     * exactly 2^N unique subsets without generating duplicate orderings (like
     * [2,1]).
     * - Inside each of those 2^N recursive calls, we do an O(N) operation to copy
     * the currentPath.
     * 
     * Space Complexity: O(N) Auxiliary Space (recursive call stack + currentPath
     * list),
     * plus O(N * 2^N) for the output array.
     * 
     * Why it's best: This N-ary tree template scales easily to other problems
     * (Permutations,
     * Combination Sum, N-Queens) where you have multiple choices, not just yes/no.
     */
    public List<List<Integer>> subsetsMy(int[] nums) {
        backtrack(new ArrayList<>(), nums, 0);
        return solution;
    }

    public void backtrack(List<Integer> currentPath, int[] choices, int index) {

        solution.add(new ArrayList<>(currentPath));

        if (index >= choices.length)
            return;

        for (int i = index; i < choices.length; i++) {

            // CHOOSE (Add to current path/state)
            currentPath.add(choices[i]);

            // EXPLORE (Recursive call)
            backtrack(currentPath, choices, i + 1);

            // UN-CHOOSE (The actual "Backtrack" step)
            currentPath.remove(currentPath.size() - 1);
        }

    }

    /*
     * NeetCode Approach 2: BINARY DECISION TREE (Include / Exclude)
     * 
     * Time Complexity: O(N * 2^N)
     * - This creates a strict binary tree of depth N. Every index branches into
     * exactly
     * 2 paths (Include or Exclude). A binary tree of depth N has exactly 2^N leaf
     * nodes.
     * - At each of those 2^N leaf nodes, we do an O(N) operation to copy the
     * subset.
     * 
     * Space Complexity: O(N) Auxiliary Space (recursive call stack max depth is N).
     * 
     * Concept: At every index 'i', we make a strict yes/no decision. We only save
     * the
     * subset when we reach the end of the array (the base case leaf nodes).
     */
    public List<List<Integer>> subsetsNeetCode(int[] nums) {
        dfs(new ArrayList<>(), nums, 0);
        return solution;
    }

    public void dfs(List<Integer> currentPath, int[] nums, int index) {
        // Base Case: If we have made a decision for every single number
        if (index >= nums.length) {
            solution.add(new ArrayList<>(currentPath));
            return;
        }

        // --- BRANCH 1: INCLUDE the current number ---
        currentPath.add(nums[index]);
        dfs(currentPath, nums, index + 1);

        // --- BRANCH 2: EXCLUDE the current number ---
        // First, we undo the "include" decision by removing the number we just added
        currentPath.remove(currentPath.size() - 1);
        // Then, we move forward without it
        dfs(currentPath, nums, index + 1);
    }

    // USELESS solution, 52ms(leetcode best is 0-1 ms) beats only 1% solutions
    // Time complexity $O(N! * 2^N * N).

    public List<List<Integer>> subsetsBAD(int[] nums) {
        solution = new ArrayList<>();
        backtrack(new ArrayList<>(), nums);
        return solution;
    }

    public boolean isValid(List<Integer> currentPath) {
        List<Integer> sortedCopy = new ArrayList<>(currentPath);
        Collections.sort(sortedCopy);
        for (List<Integer> val : solution) {
            if (val.equals(sortedCopy))
                return false;
        }

        return true;
    }

    public void backtrack(List<Integer> currentPath, int[] choices) {

        List<Integer> sortedCopy = new ArrayList<>(currentPath);
        Collections.sort(sortedCopy);
        solution.add(sortedCopy);

        if (choices.length == 0)
            return;

        for (int i = 0; i < choices.length; i++) {
            currentPath.add(choices[i]);

            if (!isValid(currentPath)) {
                currentPath.remove(currentPath.size() - 1);
                continue;
            }

            int[] newChoices = new int[choices.length - 1];
            for (int j = 0, k = 0; j < choices.length; j++) {
                if (i != j)
                    newChoices[k++] = choices[j];
            }

            backtrack(currentPath, newChoices);
            currentPath.remove(currentPath.size() - 1);
        }

    }
}
