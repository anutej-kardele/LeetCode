package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PN22 {

    List<String> solution = new ArrayList<>();

    public static void main(String[] args) {

        PN22 solution = new PN22();
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {

        backtrack(n, 0, 0, 0, new StringBuilder());
        return solution;
    }

    public void backtrack(int n, int index, int open, int closed, StringBuilder curr) {

        if (closed > open)
            return;

        if (index >= n * 2) {
            solution.add(curr.toString());
            return;
        }

        // String str = curr;

        if (open < n) {
            curr.append('(');
            backtrack(n, index + 1, open + 1, closed, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

        // call closed
        if (closed < open) {
            curr.append(')');
            backtrack(n, index + 1, open, closed + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

    }

}
