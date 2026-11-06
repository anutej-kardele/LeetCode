package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PN90 {

    List<List<Integer>> solution = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backtrack(new ArrayList<>(), nums, 0);
        return solution;
    }

    public void backtrack(List<Integer> currentPath, int[] choices, int index) {

        solution.add(new ArrayList<>(currentPath));

        if (index >= choices.length)
            return;

        for (int i = index; i < choices.length; i++) {

            if (i > index && choices[i] == choices[i - 1])
                continue;

            currentPath.add(choices[i]);

            backtrack(currentPath, choices, i + 1);

            currentPath.remove(currentPath.size() - 1);
        }

    }
}
