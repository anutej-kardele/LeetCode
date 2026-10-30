package LeetCode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class PN150 {

    public static void main(String[] args) {

        String[] tokens = { "2", "1", "+", "3", "*" };
        PN150 solution = new PN150();
        System.out.println("Expected 9: Got: " + solution.evalRPN(tokens)); // Output: 9

        tokens = new String[] { "4", "13", "5", "/", "+" };
        System.out.println("Expected 6: Got: " + solution.evalRPN(tokens)); // Output: 6

        tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println("Expected 22: Got: " + solution.evalRPN(tokens)); // Output: 22

    }

    public int evalRPN(String[] tokens) {

        // char[] token = tokens.;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("+")) {
                // adition
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else if (tokens[i].equals("-")) {
                // subtract
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (tokens[i].equals("*")) {
                // multiply
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if (tokens[i].equals("/")) {
                // divide
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                // number
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }

}
