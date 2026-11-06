package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PN40 {

    List<List<Integer>> solution = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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

            if (currentSum + candidates[i] > target)
                break;

            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            currentPath.add(candidates[i]);
            currentSum += candidates[i];

            backtrack(currentPath, candidates, target, currentSum, i + 1);

            currentPath.remove(currentPath.size() - 1);
            currentSum -= candidates[i];
        }
    }
}
