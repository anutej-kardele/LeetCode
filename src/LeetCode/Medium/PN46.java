package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PN46 {

    List<List<Integer>> solution = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return solution;
    }

    public void backtrack(List<Integer> currentPath, int[] choices, boolean[] active) {

        if (currentPath.size() == choices.length) {
            solution.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = 0; i < choices.length; i++) {

            if (active[i])
                continue;

            // CHOOSE (Add to current path/state)
            currentPath.add(choices[i]);
            active[i] = true;

            // EXPLORE (Recursive call)
            backtrack(currentPath, choices, active);

            // UN-CHOOSE (The actual "Backtrack" step)
            currentPath.remove(currentPath.size() - 1);
            active[i] = false;
        }

    }
}
