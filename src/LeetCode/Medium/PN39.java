package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PN39 {

    List<List<Integer>> solution = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(new ArrayList<>(), candidates, target, 0, 0);
        return solution;
    }

    public void backtrack(List<Integer> currentPath, int[] candidates, int target, int currentSum, int index) {

        if (currentSum >= target) {
            if (currentSum == target)
                solution.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            currentPath.add(candidates[i]);
            currentSum += candidates[i];

            backtrack(currentPath, candidates, target, currentSum, i);

            currentPath.remove(currentPath.size() - 1);
            currentSum -= candidates[i];
        }

    }

}
